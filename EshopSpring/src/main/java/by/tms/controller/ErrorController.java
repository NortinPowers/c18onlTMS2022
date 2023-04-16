package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static by.tms.utils.Constants.MappingPath.ERROR_404;
import static by.tms.utils.Constants.MappingPath.ERROR_500;

@Controller
public class ErrorController {

    @GetMapping("/500")
    public String error500() {
        return ERROR_500;
    }

    @GetMapping("/404")
    public String error404() {
        return ERROR_404;
    }
}