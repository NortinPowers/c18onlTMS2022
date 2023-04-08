package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products-page")
    public String products(@RequestParam("type") String type, Model model) {
        List<ProductDto> products = productService.getProductsByType(type);
        model.addAttribute("products", products);
        return "products";
    }

}
