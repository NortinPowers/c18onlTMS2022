package by.tms.controller.impl;

import static by.tms.model.PagesPath.FAVORITES_PAGE;
import static by.tms.model.RequestParameters.ID;
import static by.tms.utils.ServiceUtils.getCartService;
import static by.tms.utils.ServiceUtils.getUserService;
import static by.tms.utils.ServletUtils.getLogin;

import by.tms.controller.Command;
import by.tms.service.CartService;
import by.tms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeleteFavoriteCommandImpl implements Command {

    private final CartService cartService = getCartService();
    private final UserService userService = getUserService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        String login = getLogin(request);
        try {
            Long id = Long.parseLong(request.getParameter(ID.getValue()));
            cartService.deleteProduct(userService.getUserId(login), id, false, true);
        } catch (Exception e) {
            log.error("Exception (get-DelFPS): " + e);
        }
        return FAVORITES_PAGE.getPath();
    }
}