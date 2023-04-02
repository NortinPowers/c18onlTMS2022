package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_JSP_PAGE;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.USER_UUID;
import static by.tms.utils.Constants.RequestParameters.RESULT;
import static by.tms.utils.Constants.SAVE;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import lombok.Setter;

@Setter
public class SearchPageCommandController implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        Set<Product> productsByUserSearchCondition = new LinkedHashSet<>();
        request.getServletContext().removeAttribute("filter");
        if ("true".equals(request.getParameter("filter"))) {
            request.getServletContext().setAttribute("filter", new Object());
        } else if (request.getSession().getAttribute(USER_UUID) != null) {
            String userUUID = request.getSession().getAttribute(USER_UUID).toString();
            if (!SAVE.equals(request.getParameter(RESULT))) {
                productService.deleteFoundProducts(userUUID);
            }
            productsByUserSearchCondition = productService.getProductsByUserSearchCondition(userUUID);
        }
        request.getServletContext().setAttribute(FOUND_PRODUCTS, productsByUserSearchCondition);
        return SEARCH_JSP_PAGE;
    }
}