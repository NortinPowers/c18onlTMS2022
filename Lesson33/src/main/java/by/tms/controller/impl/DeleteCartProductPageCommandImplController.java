package by.tms.controller.impl;

import static by.tms.model.PagesPath.SHOPPING_CART_PAGE;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.service.CartService;
import by.tms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class DeleteCartProductPageCommandImplController implements CommandController {

    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;
//    private final CartService cartService = getCartService();
//    private final UserService userService = getUserService();

//    @Override
//    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        String login = getLogin(request);
//        Long id = Long.parseLong(request.getParameter(ID.getValue()));
//        cartService.deleteProduct(userService.getUserId(login), id, true, false);
//        return SHOPPING_CART_PAGE.getPath();
//    }

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = getLogin(request);
        Long id = Long.parseLong(request.getParameter(ID));
        cartService.deleteProduct(userService.getUserId(login), id, true, false);
        return SHOPPING_CART_PAGE;
    }
}