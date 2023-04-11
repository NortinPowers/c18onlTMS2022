package by.tms.controller;

import by.tms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductsPageController {

    private final ProductService productService;

//    public ProductsPageController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products-page")
    public String products(@RequestParam("type") String type, Model model) {
//        List<ProductDto> products = productService.getProductsByType(type);
        model.addAttribute("products", productService.getProductsByType(type));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

}
