package by.tms.utils;

import static by.tms.model.Attribute.ACCESS_PERMISSION;
import static by.tms.model.Attribute.USER_NAME;
import static by.tms.model.Attribute.USER_UUID;
import static by.tms.model.MdcKey.CONVERSATION;

import by.tms.model.Order;
import by.tms.model.Ordering;
import by.tms.model.Product;
import by.tms.model.User;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
@UtilityClass
public class ServletUtils {

    public static void saveUserSession(HttpServletRequest req, String login) {
        HttpSession session = req.getSession();
        User user = User.builder()
                        .login(login)
                        .build();
        session.setAttribute(ACCESS_PERMISSION.getAttribute(), user);
        log.info("The user with a login " + user.getLogin() + " is logged in");
        session.setAttribute(USER_NAME.getAttribute(), login);
        String userUUID = UUID.randomUUID().toString();
        MDC.put(CONVERSATION.getKey(), userUUID);
        session.setAttribute(USER_UUID.getAttribute(), userUUID);
        log.info("User with the login " + user.getLogin() + " has been assigned a UUID");
    }

    public static String getLogin(HttpServletRequest req) {
        if (req.getSession().getAttribute(USER_NAME.getAttribute()) != null) {
            return req.getSession().getAttribute(USER_NAME.getAttribute()).toString();
        } else {
            return null;
        }
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

    public static void forwardToAddress(HttpServletRequest request, HttpServletResponse response, String address) throws ServletException, IOException {
//        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}