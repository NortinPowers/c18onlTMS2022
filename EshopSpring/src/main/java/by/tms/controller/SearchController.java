package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Set;

import static by.tms.utils.Constants.Attributes.FILTER_FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_SEARCH_FILTER_TRUE_RESULT_SAVE;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_SEARCH_RESULT_SAVE;
import static by.tms.utils.Constants.MappingPath.SEARCH_PATH;
import static by.tms.utils.Constants.RequestParameters.FILTER;
import static by.tms.utils.Constants.RequestParameters.MAX_PRICE;
import static by.tms.utils.Constants.RequestParameters.MIN_PRICE;
import static by.tms.utils.Constants.RequestParameters.SEARCH_CONDITION;
import static by.tms.utils.Constants.RequestParameters.SELECT;
import static by.tms.utils.Constants.SAVE;
import static by.tms.utils.Constants.TRUE;
import static by.tms.utils.ControllerUtils.applyPriceFilterOnProducts;
import static by.tms.utils.ControllerUtils.applyTypeFilterOnProducts;
import static by.tms.utils.ControllerUtils.getPrice;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final ProductService productService;

    @GetMapping("/search")
    public ModelAndView showSearchPage(HttpServletRequest request,
                                       @RequestParam(required = false) String result,
                                       @RequestParam(required = false) String filter) {
        HttpSession session = request.getSession();
        if (!SAVE.equals(result)) {
            session.removeAttribute(FOUND_PRODUCTS);
            session.removeAttribute(FILTER_FOUND_PRODUCTS);
        }
        request.getServletContext().removeAttribute(FILTER);
        if (TRUE.equals(filter)) {
            request.getServletContext().setAttribute(FILTER, new Object());
        }
        return new ModelAndView(SEARCH_PATH);
    }

    @PostMapping("/search-param")
    public ModelAndView showSearchPageByParam(HttpServletRequest request,
                                              @RequestParam(name = SEARCH_CONDITION) String searchCondition) {
        request.getServletContext().removeAttribute(FILTER);
        if (!searchCondition.isEmpty()) {
            Set<ProductDto> products = productService.getFoundProducts(searchCondition);
            HttpSession session = request.getSession();
            session.setAttribute(FOUND_PRODUCTS, products);
        }
        return new ModelAndView(REDIRECT_TO_SEARCH_RESULT_SAVE);
    }

    @PostMapping("/search-filter")
    public ModelAndView showSearchPageByFilter(HttpServletRequest request,
                                               @RequestParam(required = false, name = SELECT) String type) {
        BigDecimal minPrice = getPrice(request, MIN_PRICE, BigDecimal.ZERO);
        BigDecimal maxPrice = getPrice(request, MAX_PRICE, new BigDecimal(Long.MAX_VALUE));
        return new ModelAndView(getSearchFilterResultPagePath(request, minPrice, maxPrice, type));
    }

    private String getSearchFilterResultPagePath(HttpServletRequest request, BigDecimal minPrice, BigDecimal maxPrice, String type) {
        String path;
        Set<ProductDto> products;
        HttpSession session = request.getSession(false);
        if (session.getAttribute(FOUND_PRODUCTS) != null) {
            products = (Set<ProductDto>) session.getAttribute(FOUND_PRODUCTS);
            products = applyPriceFilterOnProducts(minPrice, maxPrice, products);
            products = applyTypeFilterOnProducts(type, products);
            session.setAttribute(FILTER_FOUND_PRODUCTS, products);
            path = REDIRECT_TO_SEARCH_FILTER_TRUE_RESULT_SAVE;
        } else {
            products = productService.selectAllProductsByFilter(type, minPrice, maxPrice);
            session.setAttribute(FOUND_PRODUCTS, products);
            path = REDIRECT_TO_SEARCH_RESULT_SAVE;
        }
        return path;
    }
}