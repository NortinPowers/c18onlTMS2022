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

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.setAddressAndForward;

@WebServlet("/add-favorite")
public class AddFavoriteProductsServlet extends HttpServlet {
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
//            productService.addFavoriteProduct(id);
            cartService.addProductToCart(customerService.getUserId(login), id, false, true);
//            setAddressAndForward(req, resp, id, productService.getFavoriteProducts());
            setAddressAndForward(req, resp, productService.getProductTypeValue(id));
        } catch (Exception e) {
            System.out.println("Exception (get-AddFPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}