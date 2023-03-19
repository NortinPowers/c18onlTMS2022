package by.tms.filter;

import static by.tms.model.PagesPath.HOME_PAGE;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/view/navigate.jsp")
public class LockPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getServletContext().getRequestDispatcher(HOME_PAGE.getPath()).forward(servletRequest, servletResponse);
    }
}