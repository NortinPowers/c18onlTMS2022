package by.tms.controller.impl;

import static by.tms.model.PagesPath.SHOPPING_CART_PAGE;
import static by.tms.model.PagesPath.SUCCESS_BUY_JSP_PAGE;
import static by.tms.utils.Constants.RequestParameters.BUY;
import static by.tms.utils.ServletUtils.createOrderNumber;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.UserService;
import by.tms.utils.Constants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class ShoppingCartProcessingPageCommandController implements CommandController {

    @Inject
    private OrderService orderService;
    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = getLogin(request);
        Long userId = userService.getUserId(login);
        PagesPath path;
        String buyButton = request.getParameter(BUY);
        if (buyButton.equals(Constants.BUY)) {
            List<Product> products = cartService.getPurchasedProducts(userId, true, false);
            String orderNumber = "";
            while (!orderService.checkOrderNumber(orderNumber) || "".equals(orderNumber)) {
                orderNumber = createOrderNumber(userId);
            }
            orderService.createOrder(orderNumber, userId);
            String finalOrderNumber = orderNumber;
            products.forEach(product -> orderService.saveProductInOrderConfigurations(finalOrderNumber, product));
            cartService.deleteCartProductsAfterBuy(userId);
            path = SUCCESS_BUY_JSP_PAGE;
        } else {
            path = SHOPPING_CART_PAGE;
        }
        return path;
    }
}