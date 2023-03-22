package by.tms.controller.impl;

import static by.tms.utils.ControllerUtils.getHomePagePath;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;

public class HomePageCommandImplController implements CommandController {

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        return getHomePagePath();
    }
}