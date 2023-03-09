package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getOrderService;
import static by.tms.utils.ServletUtils.getOrderViews;
import static by.tms.utils.ServletUtils.getUserService;

import by.tms.model.Order;
import by.tms.model.Ordering;
import by.tms.model.User;
import by.tms.service.OrderService;
import by.tms.service.UserService;
import by.tms.utils.ServletUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private UserService userService;
    private OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = getUserService(config);
        orderService = getOrderService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = ServletUtils.getLogin(req);
        User user = userService.getUserByLogin(login);
        req.getServletContext().setAttribute("user", user);
        Long userId = userService.getUserId(login);
        List<Order> orders = orderService.getOrdersById(userId);
        List<Ordering> orderings = getOrderViews(orders);
        req.getServletContext().setAttribute("orderings", orderings);
        forwardToAddress(req, resp, "/view/account.jsp");
    }
}