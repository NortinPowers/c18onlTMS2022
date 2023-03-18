package by.tms.controller.impl;

import static by.tms.model.Attribute.PRODUCTS;
import static by.tms.model.PagesPath.PRODUCTS_PAGE;
import static by.tms.model.RequestParameters.TYPE;
import static by.tms.utils.ServiceUtils.getProductService;

import by.tms.controller.Command;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductPageCommandImpl implements Command {

    private final ProductService productService = getProductService();

    @Override
    public String getStringByGET(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.getProductsByType(request.getParameter(TYPE.getValue()));
        request.getServletContext().setAttribute(PRODUCTS.getAttribute(), products);
        return PRODUCTS_PAGE.getPath();
    }
}