package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.FILTER;
import static by.tms.utils.Constants.RequestParameters.SEARCH_CONDITION;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Setter;

@Setter
public class SearchQueryPageCommandController implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String searchCondition = request.getParameter(SEARCH_CONDITION);
        request.getServletContext().removeAttribute(FILTER);
        if (!searchCondition.isEmpty()) {
            Set<Product> products = productService.getFoundProducts(searchCondition);
            HttpSession session = request.getSession();
            session.setAttribute(FOUND_PRODUCTS, products);
        }
        return SEARCH_JSP_PAGE;
    }
}