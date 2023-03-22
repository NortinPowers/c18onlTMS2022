package by.tms.controller;

import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;

public interface CommandController {

//    default String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
//        if (request.getMethod().equalsIgnoreCase(GET.getValue())) {
//            return getStringByGET(request, response);
//        } else {
//            return getStringByPOST(request, response);
//        }
//    }

    PagesPath execute(HttpServletRequest request) throws CommandException;

//    default String getStringByPOST(HttpServletRequest request, HttpServletResponse response) {
//        return getHomePagePath();
//    }
//
//    default String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
//        return getHomePagePath();
//    }
}