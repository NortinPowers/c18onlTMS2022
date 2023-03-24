package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_JSP_PAGE;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;

public class SearchPageCommandControllerImpl implements CommandController {

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        return SEARCH_JSP_PAGE;
    }
}
