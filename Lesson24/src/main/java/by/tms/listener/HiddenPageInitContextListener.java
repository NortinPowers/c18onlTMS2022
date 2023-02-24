package by.tms.listener;

import by.tms.model.Authenticator;
import by.tms.service.SecurityService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HiddenPageInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Authenticator authenticator = new Authenticator(null);
        authenticator.getAuthenticators().put("test", "test");
        SecurityService security = new SecurityService(authenticator);
        sce.getServletContext().setAttribute("security", security);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("security", null);
    }
}