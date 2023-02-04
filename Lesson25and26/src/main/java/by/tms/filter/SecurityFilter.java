package by.tms.filter;

import by.tms.servlet.IndexServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/open-page.jsp", "/create.jsp", "/delete.jsp", "/create", "/delete", "/students"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (IndexServlet.getAccess() == null) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}