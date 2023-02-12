package by.tms.servlet;

import by.tms.model.Product;
import by.tms.service.CartServiceAware;
import by.tms.service.CustomerServiceAware;
import org.apache.commons.lang3.tuple.Pair;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.tms.utils.ServletUtils.forwardToAddress;

@WebServlet("/view/favorites")
public class FavoriteProductsServlet extends HttpServlet {
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
//        Set<Product> favoriteProducts = productService.getFavoriteProducts();
        String login = req.getSession().getAttribute("userName").toString();
        Long userId = customerService.getUserId(login);
        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                .map(Pair::getLeft)
                .toList();
        req.getServletContext().setAttribute("favoriteProducts", favoriteProducts);
        forwardToAddress(req, resp, "/view/favorites.jsp");
    }
}