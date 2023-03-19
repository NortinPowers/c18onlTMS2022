package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAVORITES_PAGE;
import static by.tms.model.PagesPath.SHOPPING_CART_PAGE;
import static by.tms.model.RequestParameters.FAVORITE;
import static by.tms.model.RequestParameters.ID;
import static by.tms.model.RequestParameters.LOCATION;
import static by.tms.model.RequestParameters.SHOP;
import static by.tms.model.RequestParameters.TRUE;
import static by.tms.utils.ControllerUtils.getHomePagePath;
import static by.tms.utils.ControllerUtils.getPathByType;
import static by.tms.utils.ServiceUtils.getCartService;
import static by.tms.utils.ServiceUtils.getProductService;
import static by.tms.utils.ServiceUtils.getUserService;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.Command;
import by.tms.service.CartService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddCartPageCommandImpl implements Command {

    private final ProductService productService = getProductService();
    private final CartService cartService = getCartService();
    private final UserService userService = getUserService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        String path;
        try {
            Long id = Long.parseLong(request.getParameter(ID.getValue()));
            String shopFlag = request.getParameter(SHOP.getValue());
            String location = request.getParameter(LOCATION.getValue());
            cartService.addProductToCart(userService.getUserId(login), id, true, false);
            if (Objects.equals(shopFlag, TRUE.getValue())) {
                path = SHOPPING_CART_PAGE.getPath();
            } else if (Objects.equals(location, FAVORITE.getValue())) {
                path = FAVORITES_PAGE.getPath();
            } else {
                path = getPathByType(productService.getProductTypeValue(id));
            }
        } catch (Exception e) {
            log.error("Exception (get-AddCPS): " + e);
            return getHomePagePath();
        }
        return path;
    }
}