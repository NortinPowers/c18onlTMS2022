package by.tms.controller;

import by.tms.service.ProductService;
import by.tms.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static by.tms.utils.Constants.MappingPath.PRODUCT;
import static by.tms.utils.Constants.MappingPath.PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.TYPE;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products-page")
    public String products(@RequestParam(TYPE) String type, Model model) {
        model.addAttribute(Constants.Attributes.PRODUCTS, productService.getProductsByType(type));
        return PRODUCTS;
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable(ID) Long id, Model model) {
        model.addAttribute(Constants.Attributes.PRODUCT, productService.getProduct(id));
        return PRODUCT;
    }
}