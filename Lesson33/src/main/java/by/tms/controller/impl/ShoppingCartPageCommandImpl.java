package by.tms.controller.impl;

import static by.tms.model.PagesPath.SHOPPING_CART_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.CART_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FULL_PRICE;
import static by.tms.utils.Constants.Attributes.USER_NAME;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Setter
public class ShoppingCartPageCommandImpl implements CommandController {

    //    @Inject
//    private OrderService orderService;
    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;
//    private final UserService userService = getUserService();
//    private final OrderService orderService = getOrderService();
//    private final CartService cartService = getCartService();

//    @Override
//    public String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
//        String buyButton = request.getParameter(BUY.getValue());
//        String login = getLogin(request);
//        Long userId = userService.getUserId(login);
//        String path;
//        if (Constants.BUY.equals(buyButton)) {
//            List<Product> products = cartService.getPurchasedProducts(userId, true, false);
//            String number = createOrderNumber(userId, products);
//            orderService.createOrder(number, userId);
//            products.forEach(product -> orderService.saveProductInOrderConfigurations(number, product));
//            cartService.deleteCartProductsAfterBuy(userId);
//            path = SUCCESS_BUY_JSP_PAGE.getPath();
//        } else {
//            path = SHOPPING_CART_PAGE.getPath();
//        }
//        return path;
//    }

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        String login = request.getSession().getAttribute(USER_NAME.getAttribute()).toString();
//        Long userId = userService.getUserId(login);
//        List<Pair<Product, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
//        request.getServletContext().setAttribute(CART_PRODUCTS.getAttribute(), cartProducts);
//        request.getServletContext().setAttribute(FULL_PRICE.getAttribute(), cartService.getProductsPrice(cartProducts));
//        return SHOPPING_CART_JSP_PAGE.getPath();
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = request.getSession().getAttribute(USER_NAME).toString();
        Long userId = userService.getUserId(login);
        List<Pair<Product, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        request.getServletContext().setAttribute(CART_PRODUCTS, cartProducts);
        request.getServletContext().setAttribute(FULL_PRICE, cartService.getProductsPrice(cartProducts));
        return SHOPPING_CART_JSP_PAGE;
    }
}