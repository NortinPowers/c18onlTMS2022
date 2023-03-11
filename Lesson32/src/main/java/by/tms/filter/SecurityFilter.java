package by.tms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/view/success-buy.jsp", "/view/favorites.jsp", "/view/favorites", "/view/shopping-cart.jsp", "/view/shopping-cart", "/view/success-register.jsp", "/view/success-register", "/add-cart", "/add-favorite", "/delete-favorite", "/delete-cart-product", "/view/account.jsp",
        "/view/account", "/account",})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        if (session.getAttribute("accessPermission") == null) {
            RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}