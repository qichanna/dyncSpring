package liqi;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liqi on 2016/5/28.
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response2 =(HttpServletResponse) servletResponse;
        System.out.println("start------doFilter--FirstFilter");
//        response2.sendRedirect(req.getContextPath()+"/main.jsp");
		req.getRequestDispatcher("main.jsp").forward(servletRequest, servletResponse);
//		req.getRequestDispatcher("main.jsp").include(request, response);
        System.out.println("end------doFilter--FirstFilter");
    }

    @Override
    public void destroy() {
        System.out.println("init----FirstFilter");
    }
}
