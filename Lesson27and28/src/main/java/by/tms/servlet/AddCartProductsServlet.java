package by.tms.servlet;


import by.tms.service.CartServiceAware;
import by.tms.service.CustomerServiceAware;
import by.tms.service.ProductServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.setAddressAndForward;

@WebServlet("/add-cart")
public class AddCartProductsServlet extends HttpServlet {
    private ProductServiceAware productService;
    private CartServiceAware cartService;
    private CustomerServiceAware customerService;
//    private String login;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
        cartService = (CartServiceAware) config.getServletContext().getAttribute("cartService");
        customerService = (CustomerServiceAware) config.getServletContext().getAttribute("customerService");
//        login = (String) config.getServletContext().getAttribute("userName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("userName").toString();
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String shopFlag = req.getParameter("shop");
            String location = req.getParameter("location");
//            productService.addCartProduct(id);
            cartService.addProductToCart(customerService.getUserId(login), id, true, false);
            if (Objects.equals(shopFlag, "true")) {
                forwardToAddress(req, resp, "/view/shopping-cart");
            } else if (Objects.equals(location, "favorite")) {
                forwardToAddress(req, resp, "/view/favorites");
            } else {
                setAddressAndForward(req, resp, productService.getProductTypeValue(id));
            }
        } catch (Exception e) {
            System.out.println("Exception (get-AddCPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}