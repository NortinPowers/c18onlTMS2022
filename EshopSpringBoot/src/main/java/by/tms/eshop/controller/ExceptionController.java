package by.tms.eshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static by.tms.eshop.utils.Constants.MappingPath.*;

@RestController
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