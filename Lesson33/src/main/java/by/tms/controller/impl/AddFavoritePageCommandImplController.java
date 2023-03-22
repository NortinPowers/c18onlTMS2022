package by.tms.controller.impl;

import static by.tms.model.RequestParameters.ID;
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
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

//@Slf4j
@Setter
public class AddFavoritePageCommandImplController implements CommandController {

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
        try {
            Long id = Long.parseLong(request.getParameter(ID.getValue()));
            cartService.addProductToCart(userService.getUserId(login), id, false, true);
//            path = getPathByType(productService.getProductTypeValue(id));
            String productType = productService.getProductTypeValue(id);
            path = getPagePathByType(productType);
        } catch (Exception e) {
            throwCommandException(request, e, this.getClass());
//            log.error("Exception (get-AddFPS): ", e);
//            return getHomePagePath();
        }
        return path;
    }
}