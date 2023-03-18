package by.tms.controller.impl;

import static by.tms.model.Attribute.ACCESS_PERMISSION;
import static by.tms.model.Attribute.USER_UUID;
import static by.tms.utils.ControllerUtils.getHomePagePath;

import by.tms.controller.Command;
import by.tms.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogoutPageCommandImpl implements Command {

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ACCESS_PERMISSION.getAttribute());
        String userUUID = (String) session.getAttribute(USER_UUID.getAttribute());
        log.info("User [" + userUUID + "] with a login " + user.getLogin() + " logged out of the system");
        session.removeAttribute(ACCESS_PERMISSION.getAttribute());
        session.removeAttribute(USER_UUID.getAttribute());
        session.invalidate();
        return getHomePagePath();
    }
}