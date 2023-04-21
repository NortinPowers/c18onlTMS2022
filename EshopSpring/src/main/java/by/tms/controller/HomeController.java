package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.utils.Constants.MappingPath.ESHOP;

@Controller
public class HomeController {

    @GetMapping(value = "/", produces = "text/html")
    public ModelAndView redirectToEshopPage() {
        return new ModelAndView(ESHOP);
    }

    @GetMapping("/eshop")
    public ModelAndView showEshopPage() {
        return new ModelAndView(ESHOP);
    }
}