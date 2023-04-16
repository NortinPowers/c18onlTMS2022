package by.tms.controller.impl;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.tms.model.PagesPath.SEARCH_SAVED_RESULT_PAGE;
import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.FILTER;
import static by.tms.utils.Constants.RequestParameters.RESULT;
import static by.tms.utils.Constants.SAVE;
import static by.tms.utils.Constants.TRUE;

public class SearchPageCommandController implements CommandController {

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        if (!SAVE.equals(request.getParameter(RESULT))) {
            session.removeAttribute(FOUND_PRODUCTS);
            session.removeAttribute(FILTER_FOUND_PRODUCTS);
        }
        request.getServletContext().removeAttribute(FILTER);
        if (TRUE.equals(request.getParameter(FILTER))) {
            request.getServletContext().setAttribute(FILTER, new Object());
        }
        return SEARCH_SAVED_RESULT_PAGE;
    }
}