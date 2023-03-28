package by.tms.controller.impl;

import static by.tms.model.PagesPath.LOGIN_JSP_PAGE;
import static by.tms.utils.Constants.RequestParameters.NAME;
import static by.tms.utils.Constants.RequestParameters.PASSWORD;
import static by.tms.utils.ControllerUtils.getHomePagePath;
import static by.tms.utils.ServletUtils.saveUserSession;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class LoginPagePostCommandControllerImpl implements CommandController {

    @Inject
    private UserService userService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(NAME);
        String password = request.getParameter(PASSWORD);
        PagesPath path;
        if (userService.isVerifiedUser(login, password)) {
            saveUserSession(request, login);
            path = getHomePagePath();
        } else {
            path = LOGIN_JSP_PAGE;
        }
        return path;
    }
}