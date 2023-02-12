package by.tms.servlet;

import by.tms.service.CartServiceAware;
import by.tms.service.CustomerServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.utils.ServletUtils.forwardToAddress;

@WebServlet("/delete-favorite")
public class DeleteFavoriteProductsServlet extends HttpServlet {
    //    private ProductServiceAware productService;
    private CartServiceAware cartService;
    private CustomerServiceAware customerService;
//    private String login;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
        cartService = (CartServiceAware) config.getServletContext().getAttribute("cartService");
        customerService = (CustomerServiceAware) config.getServletContext().getAttribute("customerService");
//        login = (String) config.getServletContext().getAttribute("userName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("userName").toString();
        try {
            Long id = Long.parseLong(req.getParameter("id"));
//            productService.deleteFavoriteProduct(id);
            cartService.deleteProduct(customerService.getUserId(login), id, false, true);
            forwardToAddress(req, resp, "/view/favorites");
        } catch (Exception e) {
            System.out.println("Exception (get-DelFPS): " + e.getMessage());
            forwardToAddress(req, resp, "/view/favorites");
        }
    }
}