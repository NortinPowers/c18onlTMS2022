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

import static by.tms.utils.ServletUtils.*;

@WebServlet("/add-favorite")
public class AddFavoriteServlet extends HttpServlet {
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
            cartService.addProductToCart(customerService.getUserId(login), id, false, true);
            setAddressAndForward(req, resp, productService.getProductTypeValue(id));
        } catch (Exception e) {
            System.out.println("Exception (get-AddFPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}