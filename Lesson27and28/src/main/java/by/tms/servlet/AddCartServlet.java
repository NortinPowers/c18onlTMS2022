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

import static by.tms.utils.ServletUtils.*;

@WebServlet("/add-cart")
public class AddCartServlet extends HttpServlet {
    private ProductServiceAware productService;
    private CartServiceAware cartService;
    private CustomerServiceAware customerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = getProductService(config);
        cartService = getCartService(config);
        customerService = getCustomerService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = getLogin(req);
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String shopFlag = req.getParameter("shop");
            String location = req.getParameter("location");
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