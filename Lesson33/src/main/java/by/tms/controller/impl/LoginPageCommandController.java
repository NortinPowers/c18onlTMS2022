package by.tms.controller.impl;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.tms.model.PagesPath.LOGIN_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.ACCESS_PERMISSION;
import static by.tms.utils.ControllerUtils.getHomePagePath;

public class LoginPageCommandController implements CommandController {

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        PagesPath path;
        if (session.getAttribute(ACCESS_PERMISSION) != null) {
            path = getHomePagePath();
        } else {
            path = LOGIN_JSP_PAGE;
        }
        return path;
    }
}