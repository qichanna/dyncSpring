package liqi;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by liqi on 2016/5/28.
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init-----SecondFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start---doFilter--SecondFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("end---doFilter--SecondFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destroy-----SecondFilter");
    }
}
