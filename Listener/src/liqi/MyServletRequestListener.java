package liqi;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by liqi on 2016/5/29.
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener,ServletRequestAttributeListener,ServletContextAttributeListener{

    private ArrayList<User> userList;

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request des");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        userList  = (ArrayList<User>)servletRequestEvent.getServletContext().getAttribute("userList");

        if(userList==null){
            userList = new ArrayList<User>();
        }
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        String sessionIdString = request.getSession().getId();

        if(SessionUtil.getUserBySessionId(userList,sessionIdString) == null){
            User user = new User();
            user.setSessionIdString(sessionIdString);
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIpString(request.getRemoteAddr());
            userList.add(user);
        }
        servletRequestEvent.getServletContext().setAttribute("userList",userList);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request add : " + servletRequestAttributeEvent.getName() );
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request remove : " + servletRequestAttributeEvent.getName());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("request replace : " + servletRequestAttributeEvent.getName());
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context add : " + servletContextAttributeEvent.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context remove : " + servletContextAttributeEvent.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context replace : " + servletContextAttributeEvent.getName());
    }
}
