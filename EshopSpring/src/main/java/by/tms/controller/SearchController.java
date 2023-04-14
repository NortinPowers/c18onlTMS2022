package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Set;

import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.*;
import static by.tms.utils.Constants.SAVE;
import static by.tms.utils.Constants.TRUE;
import static by.tms.utils.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
@Lazy
public class SearchController {

    private final ProductService productService;

    @GetMapping("/search")
    public String search(HttpServletRequest request,
                         @RequestParam(required = false) String result,
                         @RequestParam(required = false) String filter) {
        HttpSession session = request.getSession();
//        if (!SAVE.equals(request.getParameter(RESULT))) {
        if (!SAVE.equals(result)) {
            session.removeAttribute(FOUND_PRODUCTS);
            session.removeAttribute(FILTER_FOUND_PRODUCTS);
        }
        request.getServletContext().removeAttribute(FILTER);
//        if (TRUE.equals(request.getParameter(FILTER))) {
        if (TRUE.equals(filter)) {
            request.getServletContext().setAttribute(FILTER, new Object());
        }
        return "search/search";
//        return SEARCH_JSP_PAGE;
    }

    @PostMapping("/search-param")
    public String searchParam(HttpServletRequest request,
                              @RequestParam(name = "search-condition") String searchCondition) {
//        String searchCondition = request.getParameter(SEARCH_CONDITION);
        request.getServletContext().removeAttribute(FILTER);
        if (!searchCondition.isEmpty()) {
            Set<ProductDto> products = productService.getFoundProducts(searchCondition);
            HttpSession session = request.getSession();
            session.setAttribute(FOUND_PRODUCTS, products);
        }
        return "redirect:/search?result=save";
//        return SEARCH_JSP_PAGE;
    }

    @PostMapping("/search-filter")
    public String searchFilter(HttpServletRequest request,
                               @RequestParam(required = false, name = "select") String type) {
        BigDecimal minPrice = getPrice(request, MIN_PRICE, BigDecimal.ZERO);
        BigDecimal maxPrice = getPrice(request, MAX_PRICE, new BigDecimal(Long.MAX_VALUE));
//        String type = request.getParameter(SELECT);
//        PagesPath searchFilterResultPage;
        //        path = getSearchFilterResultPagePath(request, minPrice, maxPrice, type);
        return getSearchFilterResultPagePath(request, minPrice, maxPrice, type);
    }

    //    private PagesPath getSearchFilterResultPagePath(HttpServletRequest request, BigDecimal minPrice, BigDecimal maxPrice, String type) {
    private String getSearchFilterResultPagePath(HttpServletRequest request, BigDecimal minPrice, BigDecimal maxPrice, String type) {
//        PagesPath searchFilterResultPage;
        String path;
        Set<ProductDto> products;
        HttpSession session = request.getSession(false);
        if (session.getAttribute(FOUND_PRODUCTS) != null) {
            products = (Set<ProductDto>) session.getAttribute(FOUND_PRODUCTS);
            products = applyPriceFilterOnProducts(minPrice, maxPrice, products);
            products = applyTypeFilterOnProducts(type, products);
            session.setAttribute(FILTER_FOUND_PRODUCTS, products);
            path = "redirect:/search?filter=true&result=save";
//            path = SEARCH_FILTER_RESULT_PAGE;
        } else {
            products = productService.selectAllProductsByFilter(type, minPrice, maxPrice);
            session.setAttribute(FOUND_PRODUCTS, products);
            path = "redirect:/search?result=save";
//            path = SEARCH_ALL_RESULT_PAGE;
        }
        return path;
    }
}
