package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/", produces = "text/html")
    public String home() {
        return "eshop";
    }
}