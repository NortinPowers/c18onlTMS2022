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

import static by.tms.utils.ServletUtils.*;

@WebServlet("/view/favorites")
public class FavoritesServlet extends HttpServlet {
    private CartServiceAware cartService;
    private CustomerServiceAware customerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = getCartService(config);
        customerService = getCustomerService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = getLogin(req);
        Long userId = customerService.getUserId(login);
        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                .map(Pair::getLeft)
                .toList();
        req.getServletContext().setAttribute("favoriteProducts", favoriteProducts);
        forwardToAddress(req, resp, "/view/favorites.jsp");
    }
}