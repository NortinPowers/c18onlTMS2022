package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_ALL_RESULT_PAGE;
import static by.tms.model.PagesPath.SEARCH_FILTER_RESULT_PAGE;
import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.MAX_PRICE;
import static by.tms.utils.Constants.RequestParameters.MIN_PRICE;
import static by.tms.utils.Constants.RequestParameters.SELECT;
import static by.tms.utils.ControllerUtils.applyPriceFilterOnProducts;
import static by.tms.utils.ControllerUtils.applyTypeFilterOnProducts;
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
@SuppressWarnings("unchecked")
public class SearchFilterPageCommandController implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        BigDecimal minPrice = getPrice(request, MIN_PRICE, BigDecimal.ZERO);
        BigDecimal maxPrice = getPrice(request, MAX_PRICE, new BigDecimal(Long.MAX_VALUE));
        String type = request.getParameter(SELECT);
        PagesPath searchFilterResultPage;
        searchFilterResultPage = getSearchFilterResultPagePath(request, minPrice, maxPrice, type);
        return searchFilterResultPage;
    }

    private PagesPath getSearchFilterResultPagePath(HttpServletRequest request, BigDecimal minPrice, BigDecimal maxPrice, String type) {
        PagesPath searchFilterResultPage;
        Set<Product> products;
        HttpSession session = request.getSession(false);
        if (session.getAttribute(FOUND_PRODUCTS) != null) {
            products = (Set<Product>) session.getAttribute(FOUND_PRODUCTS);
            products = applyPriceFilterOnProducts(minPrice, maxPrice, products);
            products = applyTypeFilterOnProducts(type, products);
            session.setAttribute(FILTER_FOUND_PRODUCTS, products);
            searchFilterResultPage = SEARCH_FILTER_RESULT_PAGE;
        } else {
            products = productService.selectAllProductsByFilter(type, minPrice, maxPrice);
            session.setAttribute(FOUND_PRODUCTS, products);
            searchFilterResultPage = SEARCH_ALL_RESULT_PAGE;
        }
        return searchFilterResultPage;
    }
}