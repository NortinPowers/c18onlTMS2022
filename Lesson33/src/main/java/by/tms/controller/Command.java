package by.tms.controller;

import static by.tms.model.RequestParameters.GET;
import static by.tms.utils.ControllerUtils.getHomePagePath;

import by.tms.exception.CommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    default String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        if (request.getMethod().equalsIgnoreCase(GET.getValue())) {
            return getStringByGET(request, response);
        } else {
            return getStringByPOST(request, response);
        }
    }

    default String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
        return getHomePagePath();
    }

    default String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        return getHomePagePath();
    }
}