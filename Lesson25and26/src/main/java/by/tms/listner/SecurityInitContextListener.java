package by.tms.listner;

import by.tms.model.Authenticator;
import by.tms.service.SecurityAware;
import by.tms.service.SecurityService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class SecurityInitContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> accessMap = new HashMap<>();
        accessMap.put("test", "test");
        Authenticator authenticator = new Authenticator(accessMap);
        SecurityAware security = new SecurityService(authenticator);
        sce.getServletContext().setAttribute("security", security);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("security", null);
    }
}