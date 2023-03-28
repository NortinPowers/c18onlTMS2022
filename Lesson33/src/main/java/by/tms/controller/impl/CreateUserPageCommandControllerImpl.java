package by.tms.controller.impl;

import static by.tms.model.PagesPath.LOGIN_PAGE;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class CreateUserPageCommandControllerImpl implements CommandController {

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        return LOGIN_PAGE;
    }
}