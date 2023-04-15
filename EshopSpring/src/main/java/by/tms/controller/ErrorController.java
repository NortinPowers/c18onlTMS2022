package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/500")
    public String error500() {
        return "/error/500";
    }

    @GetMapping("/404")
    public String error404() {
        return "/error/404";
    }
}
