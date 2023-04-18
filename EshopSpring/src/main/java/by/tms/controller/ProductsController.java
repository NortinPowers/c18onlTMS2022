package by.tms.controller;

import by.tms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.TYPE;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/products-page")
//    public String products(@RequestParam(TYPE) String type, Model model) {
    public ModelAndView products(@RequestParam(TYPE) String type) {
//        model.addAttribute(Constants.Attributes.PRODUCTS, productService.getProductsByType(type));
//        return PRODUCTS;
        return productService.getProductsByType(type);
    }

    @GetMapping("/product/{id}")
    public ModelAndView product(@PathVariable(ID) Long id) {
//    public String product(@PathVariable(ID) Long id, Model model) {
//        model.addAttribute(Constants.Attributes.PRODUCT, productService.getProduct(id));
        return productService.getProduct(id);
//        return PRODUCT;
    }
}