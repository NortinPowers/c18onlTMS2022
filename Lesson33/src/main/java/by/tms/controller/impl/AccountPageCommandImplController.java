package by.tms.controller.impl;

import static by.tms.model.Attribute.ORDERINGS;
import static by.tms.model.Attribute.USER;
import static by.tms.model.PagesPath.ACCOUNT_PAGE;
import static by.tms.utils.ServletUtils.getLogin;
import static by.tms.utils.ServletUtils.getOrderings;

import by.tms.controller.CommandController;
import by.tms.model.Inject;
import by.tms.model.Order;
import by.tms.model.Ordering;
import by.tms.model.User;
import by.tms.service.OrderService;
import by.tms.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Setter;

@Setter
public class AccountPageCommandImplController implements CommandController {

    @Inject
    private UserService userService;
    //    private final UserService userService = getUserService();
    @Inject
    private OrderService orderService;
//    private final OrderService orderService = getOrderService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        User user = userService.getUserByLogin(login);
        request.getServletContext().setAttribute(USER.getAttribute(), user);
        Long userId = userService.getUserId(login);
        List<Order> orders = orderService.getOrdersById(userId);
        if (!orders.isEmpty()) {
            List<Ordering> orderings = getOrderings(orders);
            request.getServletContext().setAttribute(ORDERINGS.getAttribute(), orderings);
        } else {
            request.removeAttribute(ORDERINGS.getAttribute());
        }
        return ACCOUNT_PAGE.getPath();
    }
}