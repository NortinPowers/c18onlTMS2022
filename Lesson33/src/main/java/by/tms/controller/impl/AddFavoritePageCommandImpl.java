package by.tms.controller.impl;

import static by.tms.model.RequestParameters.ID;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddFavoritePageCommandImpl implements Command {

    private final ProductService productService = getProductService();
    private final CartService cartService = getCartService();
    private final UserService userService = getUserService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        String path;
        try {
            Long id = Long.parseLong(request.getParameter(ID.getValue()));
            cartService.addProductToCart(userService.getUserId(login), id, false, true);
            path = getPathByType(productService.getProductTypeValue(id));
        } catch (Exception e) {
            log.error("Exception (get-AddFPS): " + e);
            return getHomePagePath();
        }
        return path;
    }
}