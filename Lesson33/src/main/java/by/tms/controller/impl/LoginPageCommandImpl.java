package by.tms.controller.impl;

import static by.tms.model.Attribute.ACCESS_PERMISSION;
import static by.tms.model.PagesPath.LOGIN_JSP_PAGE;
import static by.tms.model.RequestParameters.NAME;
import static by.tms.model.RequestParameters.PASSWORD;
import static by.tms.utils.ControllerUtils.getHomePagePath;
import static by.tms.utils.ServiceUtils.getUserService;
import static by.tms.utils.ServletUtils.saveUserSession;

import by.tms.controller.Command;
import by.tms.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginPageCommandImpl implements Command {

    private final UserService userService = getUserService();

    @Override
    public String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter(NAME.getValue());
        String password = request.getParameter(PASSWORD.getValue());
        String path;
        if (userService.isVerifiedUser(login, password)) {
            saveUserSession(request, login);
            path = getHomePagePath();
        } else {
            path = LOGIN_JSP_PAGE.getPath();
        }
        return path;
    }

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String path;
        if (session.getAttribute(ACCESS_PERMISSION.getAttribute()) != null) {
            path = getHomePagePath();
        } else {
            path = LOGIN_JSP_PAGE.getPath();
        }
        return path;
    }
}