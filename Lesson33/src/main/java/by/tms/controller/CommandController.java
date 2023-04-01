package by.tms.controller;

import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import javax.servlet.http.HttpServletRequest;

public interface CommandController {

    PagesPath execute(HttpServletRequest request) throws CommandException;
}