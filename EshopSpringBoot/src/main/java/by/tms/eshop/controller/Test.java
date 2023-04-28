package by.tms.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
    @GetMapping("/test1")
    public ModelAndView test1() {
        return new ModelAndView("test1");
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
