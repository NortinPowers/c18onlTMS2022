package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_FILTER_RESULT_PAGE;
import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.ControllerUtils.checkAndGetUserUUID;

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
import org.apache.commons.lang3.StringUtils;

@Setter
public class FilterPageCommandControllerImpl implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        BigDecimal minPrice;
        BigDecimal maxPrice;
        Set<Product> products;
        if (!StringUtils.isAllBlank(request.getParameter("min-price"))) {
            minPrice = new BigDecimal(request.getParameter("min-price"));
        } else {
            minPrice = BigDecimal.ZERO;
        }
        if (!StringUtils.isAllBlank(request.getParameter("max-price"))) {
            maxPrice = new BigDecimal(request.getParameter("max-price"));
        } else {
            maxPrice = new BigDecimal(Long.MAX_VALUE);
        }
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