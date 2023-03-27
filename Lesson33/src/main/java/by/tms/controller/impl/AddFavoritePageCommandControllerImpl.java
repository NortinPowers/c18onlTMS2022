package by.tms.controller.impl;

import static by.tms.model.PagesPath.PRODUCT_JSP_PAGE;
import static by.tms.model.PagesPath.SEARCH_SAVED_RESULT_PAGE;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.LOCATION;
import static by.tms.utils.Constants.RequestParameters.PRODUCT_PAGE;
import static by.tms.utils.Constants.RequestParameters.SEARCH;
import static by.tms.utils.ControllerUtils.getHomePagePath;
import static by.tms.utils.ControllerUtils.getPagePathByType;
import static by.tms.utils.ControllerUtils.throwCommandException;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.service.CartService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

//@Slf4j
@Setter
public class AddFavoritePageCommandControllerImpl implements CommandController {

    @Inject
    private ProductService productService;
    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;

//    private final ProductService productService = getProductService();
//    private final CartService cartService = getCartService();
//    private final UserService userService = getUserService();

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        String login = getLogin(request);
//        String path;
//        try {
//            Long id = Long.parseLong(request.getParameter(ID.getValue()));
//            cartService.addProductToCart(userService.getUserId(login), id, false, true);
//            path = getPathByType(productService.getProductTypeValue(id));
//        } catch (Exception e) {
//            log.error("Exception (get-AddFPS): ", e);
//            return getHomePagePath();
//        }
//        return path;
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = getLogin(request);
        PagesPath path = getHomePagePath();
        String location = request.getParameter(LOCATION);
        try {
            Long id = Long.parseLong(request.getParameter(ID));
            cartService.addProductToCart(userService.getUserId(login), id, false, true);
//            path = getPathByType(productService.getProductTypeValue(id));
            String productType = productService.getProductTypeValue(id);
            if (Objects.equals(location, SEARCH)) {
                path = SEARCH_SAVED_RESULT_PAGE;
            } else if (Objects.equals(location, PRODUCT_PAGE)) {
                path = PRODUCT_JSP_PAGE;
            } else {
                path = getPagePathByType(productType);
            }
        } catch (Exception e) {
            throwCommandException(request, e, this.getClass());
//            log.error("Exception (get-AddFPS): ", e);
//            return getHomePagePath();
        }
        return path;
    }
}