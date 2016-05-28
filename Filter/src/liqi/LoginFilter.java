package liqi;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liqi on 2016/5/28.
 */
public class LoginFilter implements Filter {

    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        String charset = config.getInitParameter("charset");
        if(charset==null){
            charset = "UTF-8";
        }
        request.setCharacterEncoding(charset);

        if(noLoginPaths != null){
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {
                if(strArray[i] == null || "".equals(strArray[i])) continue;

                if(request.getRequestURI().indexOf(strArray[i]) != -1){
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
        }



        if(session.getAttribute("username") != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.sendRedirect( request.getContextPath() + "/login.jsp");  //不加上req.getContextPath()，路径有可能会变成liqi/login.jsp,sendRedirect的路径好像是相对路径，在当前访问的路径下+括号中的参数，作为最终路径
        }
    }

    @Override
    public void destroy() {

    }
}
