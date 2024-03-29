package by.tms.controller.impl;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.service.CartService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static by.tms.model.PagesPath.PRODUCT_JSP_PAGE;
import static by.tms.model.PagesPath.SEARCH_SAVED_RESULT_PAGE;
import static by.tms.utils.Constants.RequestParameters.*;
import static by.tms.utils.ControllerUtils.getPagePathByType;
import static by.tms.utils.ServletUtils.getLogin;

@Setter
public class AddFavoritePageCommandController implements CommandController {

    @Inject
    private ProductService productService;
    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = getLogin(request);
        PagesPath path;
        String location = request.getParameter(LOCATION);
        Long id = Long.parseLong(request.getParameter(ID));
        cartService.addProductToCart(userService.getUserId(login), id, false, true);
        String productType = productService.getProductTypeValue(id);
        if (Objects.equals(location, SEARCH)) {
            path = SEARCH_SAVED_RESULT_PAGE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = PRODUCT_JSP_PAGE;
        } else {
            path = getPagePathByType(productType);
        }
        return path;
    }
}