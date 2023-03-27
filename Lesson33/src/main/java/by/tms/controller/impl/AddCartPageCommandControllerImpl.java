package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAVORITES_PAGE;
import static by.tms.model.PagesPath.PRODUCT_JSP_PAGE;
import static by.tms.model.PagesPath.SEARCH_SAVED_RESULT_PAGE;
import static by.tms.model.PagesPath.SHOPPING_CART_PAGE;
import static by.tms.utils.Constants.RequestParameters.FAVORITE;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.LOCATION;
import static by.tms.utils.Constants.RequestParameters.PRODUCT_PAGE;
import static by.tms.utils.Constants.RequestParameters.SEARCH;
import static by.tms.utils.Constants.RequestParameters.SHOP;
import static by.tms.utils.Constants.RequestParameters.TRUE;
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
public class AddCartPageCommandControllerImpl implements CommandController {

    @Inject
    private ProductService productService;
    //    private final ProductService productService = getProductService();
    @Inject
    private CartService cartService;
    //    private final CartService cartService = getCartService();
    @Inject
    private UserService userService;
//    private final UserService userService = getUserService();

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {

//        test
//        throwCommandException(request, new Exception("exception text"), this.getClass());
//        end test

        String login = getLogin(request);
        PagesPath path = getHomePagePath();
        try {
            Long id = Long.parseLong(request.getParameter(ID));
            String shopFlag = request.getParameter(SHOP);
            String location = request.getParameter(LOCATION);
            cartService.addProductToCart(userService.getUserId(login), id, true, false);
            if (Objects.equals(shopFlag, TRUE)) {
                path = SHOPPING_CART_PAGE;
            } else if (Objects.equals(location, FAVORITE)) {
                path = FAVORITES_PAGE;
            } else if (Objects.equals(location, SEARCH)) {
                path = SEARCH_SAVED_RESULT_PAGE;
            } else if (Objects.equals(location, PRODUCT_PAGE)) {
                path = PRODUCT_JSP_PAGE;
            } else {
//                String pathByType = getPathByType(productService.getProductTypeValue(id));
                String productType = productService.getProductTypeValue(id);
                path = getPagePathByType(productType);
//                path = getPathByType(productService.getProductTypeValue(id));
            }
        } catch (Exception e) {
//            log.error("Exception (get-AddCPS): ", e);
//            String errorMessage = "Exception in " + this.getClass().getSimpleName() + ":";
            throwCommandException(request, e, this.getClass());
//            return getHomePagePath();
        }
        return path;
    }

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        String login = getLogin(request);
//        String path;
//        try {
//            Long id = Long.parseLong(request.getParameter(ID.getValue()));
//            String shopFlag = request.getParameter(SHOP.getValue());
//            String location = request.getParameter(LOCATION.getValue());
//            cartService.addProductToCart(userService.getUserId(login), id, true, false);
//            if (Objects.equals(shopFlag, TRUE.getValue())) {
//                path = SHOPPING_CART_PAGE.getPath();
//            } else if (Objects.equals(location, FAVORITE.getValue())) {
//                path = FAVORITES_PAGE.getPath();
//            } else {
//                path = getPathByType(productService.getProductTypeValue(id));
//            }
//        } catch (Exception e) {
//            log.error("Exception (get-AddCPS): ", e);
//            return getHomePagePath();
//        }
//        return path;
//    }
}