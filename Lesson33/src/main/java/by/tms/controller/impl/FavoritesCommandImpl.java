package by.tms.controller.impl;

import static by.tms.model.Attribute.FAVORITE_PRODUCTS;
import static by.tms.model.PagesPath.FAVORITES_JSP_PAGE;
import static by.tms.utils.ServiceUtils.getCartService;
import static by.tms.utils.ServiceUtils.getUserService;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.Command;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Pair;

public class FavoritesCommandImpl implements Command {

    private final CartService cartService = getCartService();
    private final UserService userService = getUserService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        Long userId = userService.getUserId(login);
        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                                                    .map(Pair::getLeft)
                                                    .toList();
        request.getServletContext().setAttribute(FAVORITE_PRODUCTS.getAttribute(), favoriteProducts);
        return FAVORITES_JSP_PAGE.getPath();
    }
}