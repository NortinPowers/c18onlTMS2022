package by.tms.controller.impl;

import static by.tms.model.PagesPath.SEARCH_PAGE;
import static by.tms.utils.Constants.Attributes.FOUND_PRODUCTS;
import static by.tms.utils.Constants.Attributes.USER_UUID;
import static by.tms.utils.Constants.CONVERSATION;
import static by.tms.utils.Constants.RequestParameters.SEARCH_CONDITION;

import by.tms.controller.CommandController;
import by.tms.exception.CommandException;
import by.tms.model.Inject;
import by.tms.model.PagesPath;
import by.tms.model.Product;
import by.tms.service.ProductService;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Setter;
import org.slf4j.MDC;

@Setter
public class SearchPagePostCommandControllerImpl implements CommandController {

    @Inject
    private ProductService productService;

    @Override
    public PagesPath execute(HttpServletRequest request) throws CommandException {
        String searchCondition = request.getParameter(SEARCH_CONDITION);
        if (!searchCondition.isEmpty()) {
            Set<Product> products = productService.getFoundProducts(searchCondition);
            HttpSession session = request.getSession(false);
            String userUUID;
            if (session.getAttribute(USER_UUID) != null) {
                userUUID = MDC.get(CONVERSATION);
            } else {
                userUUID = UUID.randomUUID().toString();
            }
            productService.saveFoundedProducts(products, userUUID);
            Set<Product> productsByUserSearchCondition = productService.getProductsByUserSearchCondition(userUUID);

            //one for all - remake
//            request.getServletContext().setAttribute(FOUND_PRODUCTS, products);
            request.getServletContext().setAttribute(FOUND_PRODUCTS, productsByUserSearchCondition);
        }
        return SEARCH_PAGE;
    }
}
