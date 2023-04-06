package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_FILTER_RESULT_PAGE;
import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.ControllerUtils.checkAndGetUserUUID;
import static by.tms.utils.ControllerUtils.getPrice;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.math.BigDecimal;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Setter;

@Setter
public class SearchFilterPageCommandController implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        BigDecimal minPrice = getPrice(request, "min-price", BigDecimal.ZERO);
        BigDecimal maxPrice = getPrice(request, "max-price", new BigDecimal(Long.MAX_VALUE));
        Set<Product> products;
        String type = request.getParameter("select");
        HttpSession session = request.getSession(false);
        String userUUID = checkAndGetUserUUID(request, session);
        if (productService.getProductsByUserSearchCondition(userUUID).size() > 0) {
            products = productService.selectFoundedProductsByFilter(type, minPrice, maxPrice, userUUID);
        } else {
            products = productService.selectAllProductsByFilter(type, minPrice, maxPrice);
            productService.deleteFoundProducts(userUUID);
            productService.saveFoundedProducts(products, userUUID);
        }
        request.getServletContext().setAttribute(FILTER_FOUND_PRODUCTS, products);
        return SEARCH_FILTER_RESULT_PAGE;
    }
}