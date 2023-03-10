package by.tms.utils;

import by.tms.model.Order;
import by.tms.model.Ordering;
import by.tms.model.Product;
import by.tms.model.User;
import by.tms.service.AuthenticatorService;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public static ProductService getProductService(ServletConfig config) {
        return (ProductService) config.getServletContext().getAttribute("productService");
    }

    public static CartService getCartService(ServletConfig config) {
        return (CartService) config.getServletContext().getAttribute("cartService");
    }

    public static AuthenticatorService getAuthenticatorService(ServletConfig config) {
        return (AuthenticatorService) config.getServletContext().getAttribute("authenticatorService");
    }

    public static UserService getUserService(ServletConfig config) {
        return (UserService) config.getServletContext().getAttribute("userService");
    }

    public static OrderService getOrderService(ServletConfig config) {
        return (OrderService) config.getServletContext().getAttribute("orderService");
    }

    public static List<Ordering> getOrderings(List<Order> orders) {
        List<Ordering> orderings = new ArrayList<>();
        Order singleOrder = orders.get(0);
        List<Product> singleOrderList = new ArrayList<>();
        addOrdering(orderings, singleOrder, singleOrderList);
        separateOrders(orders, orderings, singleOrder, singleOrderList);
        return orderings;
    }

    private void addOrdering(List<Ordering> orderings, Order singleOrder, List<Product> singleOrderList) {
        orderings.add(new Ordering(singleOrder.getId(), singleOrder.getDate(), singleOrderList));
        singleOrderList.add(singleOrder.getProduct());
    }

    private void separateOrders(List<Order> orders, List<Ordering> orderings, Order singleOrder, List<Product> singleOrderList) {
        for (int i = 1; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (singleOrder.getId().equals(order.getId())) {
                singleOrderList.add(order.getProduct());
            } else {
                singleOrder = order;
                singleOrderList = new ArrayList<>();
                addOrdering(orderings, singleOrder, singleOrderList);
            }
        }
    }

    public static String createOrderNumber(Long id, List<Product> products) {
        Order order = new Order(LocalDate.now(), id, products.size());
        return String.valueOf(order.hashCode());

    }
}