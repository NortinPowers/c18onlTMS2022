package by.tms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static by.tms.utils.Constants.MappingPath.ERROR_404;
import static by.tms.utils.Constants.MappingPath.ERROR_500;
import static by.tms.utils.Constants.MappingPath.SOME_ERROR;

@Controller
public class ExceptionController {

    @GetMapping("/error-500")
    public String showError500Page() {
        return ERROR_500;
    }

    @GetMapping("/error-404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String showError404Page() {
        return ERROR_404;
    }

    @GetMapping("/some-error")
    public String showSomeErrorPage() {
        return SOME_ERROR;
    }
}