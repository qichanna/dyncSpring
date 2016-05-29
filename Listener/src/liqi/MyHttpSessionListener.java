package liqi;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * Created by liqi on 2016/5/29.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener,HttpSessionAttributeListener,ServletContextAttributeListener{

    private int userNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);

        ArrayList<User> userList = (ArrayList<User>) httpSessionEvent.getSession().getServletContext().getAttribute("userList");

        if(SessionUtil.getUserBySessionId(userList,httpSessionEvent.getSession().getId())!= null){
            userList.remove(SessionUtil.getUserBySessionId(userList,httpSessionEvent.getSession().getId()));
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session add");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session remove");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session replace");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context add");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context remove");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("context replace");
    }
}
