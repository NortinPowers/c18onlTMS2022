package by.tms.utils;

import by.tms.model.User;
import by.tms.service.AuthenticatorServiceAware;
import by.tms.service.CartServiceAware;
import by.tms.service.CustomerServiceAware;
import by.tms.service.ProductServiceAware;
import by.tms.service.SecurityAware;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServletUtils {

    public static void setAddressAndForward(HttpServletRequest req, HttpServletResponse resp, String type) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/products?type=" + type).forward(req, resp);
    }

    public static void forwardToAddress(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }

    public static void saveUserSession(HttpServletRequest req, String login) {
        HttpSession session = req.getSession();
        session.setAttribute("accessPermission", new User(login));
        session.setAttribute("userName", login);
    }

    public static String getLogin(HttpServletRequest req) {
        return req.getSession().getAttribute("userName").toString();
    }

    public static ProductServiceAware getProductService(ServletConfig config) {
        return (ProductServiceAware) config.getServletContext().getAttribute("productService");
    }

    public static CustomerServiceAware getCustomerService(ServletConfig config) {
        return (CustomerServiceAware) config.getServletContext().getAttribute("userService");
    }

    public static CartServiceAware getCartService(ServletConfig config) {
        return (CartServiceAware) config.getServletContext().getAttribute("cartService");
    }

    public static SecurityAware getSecurity(ServletConfig config) {
        return (SecurityAware) config.getServletContext().getAttribute("security");
    }

    public static AuthenticatorServiceAware getAuthenticatorService(ServletConfig config) {
        return (AuthenticatorServiceAware) config.getServletContext().getAttribute("authenticatorService");
    }
}