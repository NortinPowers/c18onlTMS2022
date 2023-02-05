package by.tms.listner;

import by.tms.model.Authenticator;
import by.tms.service.SecurityAware;
import by.tms.service.SecurityService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;

@WebListener
public class SecurityInitContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Authenticator authenticator = new Authenticator(new HashMap<>());
        authenticator.getAuthenticators().put("test", "test");
        SecurityAware security = new SecurityService(authenticator);
        sce.getServletContext().setAttribute("security", security);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("security", null);
    }
}