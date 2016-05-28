package liqi;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by liqi on 2016/5/28.
 */
@WebFilter(filterName = "AsyncFilter",asyncSupported = true,value = {"/liqi/AsyncServlet"},dispatcherTypes = {DispatcherType.ASYNC,DispatcherType.REQUEST})
public class AsyncFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start.....AsynFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("end.....AsynFilter");
    }

    @Override
    public void destroy() {

    }
}
