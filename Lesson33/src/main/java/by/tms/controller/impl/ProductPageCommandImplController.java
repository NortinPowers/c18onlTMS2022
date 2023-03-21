package by.tms.controller.impl;

import static by.tms.model.Attribute.PRODUCTS;
import static by.tms.model.PagesPath.PRODUCTS_PAGE;
import static by.tms.model.RequestParameters.TYPE;

import by.tms.controller.CommandController;
import by.tms.model.Inject;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Setter;

@Setter
public class ProductPageCommandImplController implements CommandController {

    @Inject
    private ProductService productService;
//    private final ProductService productService = getProductService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.getProductsByType(request.getParameter(TYPE.getValue()));
        request.getServletContext().setAttribute(PRODUCTS.getAttribute(), products);
        return PRODUCTS_PAGE.getPath();
    }
}