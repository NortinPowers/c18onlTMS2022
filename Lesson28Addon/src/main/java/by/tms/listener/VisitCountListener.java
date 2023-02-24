package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class VisitCountListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AtomicInteger count = new AtomicInteger();
        sce.getServletContext().setAttribute("count", count);
    }
}