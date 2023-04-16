package by.tms.controller.impl;

import static by.tms.model.PagesPath.PRODUCTS_PAGE;
import static by.tms.utils.Constants.Attributes.PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.TYPE;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class ProductPageCommandController implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        List<Product> products = productService.getProductsByType(request.getParameter(TYPE));
        request.getServletContext().setAttribute(PRODUCTS, products);
        return PRODUCTS_PAGE;
    }
}