package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAVORITES_PAGE;
import static by.tms.model.RequestParameters.ID;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.CommandController;
import by.tms.model.Inject;
import by.tms.service.CartService;
import by.tms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class DeleteFavoriteCommandImplController implements CommandController {

    @Inject
    private CartService cartService;
    @Inject
    private UserService userService;
//    private final CartService cartService = getCartService();
//    private final UserService userService = getUserService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        try {
            Long id = Long.parseLong(request.getParameter(ID.getValue()));
            cartService.deleteProduct(userService.getUserId(login), id, false, true);
        } catch (Exception e) {
            log.error("Exception (get-DelFPS): ", e);
        }
        return FAVORITES_PAGE.getPath();
    }
}