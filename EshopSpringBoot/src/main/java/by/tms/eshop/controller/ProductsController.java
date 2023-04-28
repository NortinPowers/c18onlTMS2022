package by.tms.eshop.controller;

import by.tms.eshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.eshop.utils.Constants.RequestParameters.ID;
import static by.tms.eshop.utils.Constants.RequestParameters.TYPE;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products-page")
    public ModelAndView showProductsPage(@RequestParam(TYPE) String type) {
        return productService.getProductsByType(type);
    }

    @GetMapping("/product/{id}")
    public ModelAndView showProductPage(@PathVariable(ID) Long id) {
        return productService.getProduct(id);
    }
}