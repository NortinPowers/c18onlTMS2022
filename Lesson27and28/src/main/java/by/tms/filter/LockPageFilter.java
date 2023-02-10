package by.tms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/view/navigate.jsp")
public class LockPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getServletContext().getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}