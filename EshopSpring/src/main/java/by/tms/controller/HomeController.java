package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static by.tms.utils.Constants.MappingPath.ESHOP;

@Controller
public class HomeController {

    @GetMapping(value = "/", produces = "text/html")
    public String home() {
        return ESHOP;
    }

    @GetMapping("/eshop")
    public String eshop() {
        return ESHOP;
    }
}