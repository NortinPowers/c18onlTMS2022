package by.tms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static by.tms.utils.Constants.MappingPath.*;

@Controller
public class ExceptionController {

    @GetMapping("/500")
    public String error500() {
        return ERROR_500;
    }

    @GetMapping("/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error404() {
        return ERROR_404;
    }

    @GetMapping("/some-error")
    public String someError() {
        return SOME_ERROR;
    }
}