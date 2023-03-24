package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAVORITES_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.FAVORITE_PRODUCTS;
import static by.tms.utils.ServletUtils.getLogin;

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
public class FavoritesCommandControllerImpl implements CommandController {

    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;
//    private final CartService cartService = getCartService();
//    private final UserService userService = getUserService();

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        String login = getLogin(request);
//        Long userId = userService.getUserId(login);
//        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
//                                                    .map(Pair::getLeft)
//                                                    .toList();
//        request.getServletContext().setAttribute(FAVORITE_PRODUCTS.getAttribute(), favoriteProducts);
//        return FAVORITES_JSP_PAGE.getPath();
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = getLogin(request);
        Long userId = userService.getUserId(login);
        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                                                    .map(Pair::getLeft)
                                                    .toList();
        request.getServletContext().setAttribute(FAVORITE_PRODUCTS, favoriteProducts);
        return FAVORITES_JSP_PAGE;
    }
}