package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class VisitCountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Integer count = 1;
        sce.getServletContext().setAttribute("count", count);
    }
}