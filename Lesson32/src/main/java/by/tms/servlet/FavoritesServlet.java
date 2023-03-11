package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getCartService;
import static by.tms.utils.ServletUtils.getLogin;
import static by.tms.utils.ServletUtils.getUserService;

import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.tuple.Pair;

@WebServlet("/view/favorites")
public class FavoritesServlet extends HttpServlet {

    private CartService cartService;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = getCartService(config);
        userService = getUserService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = getLogin(req);
        Long userId = userService.getUserId(login);
        List<Product> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                                                    .map(Pair::getLeft)
                                                    .toList();
        req.getServletContext().setAttribute("favoriteProducts", favoriteProducts);
        forwardToAddress(req, resp, "/view/favorites.jsp");
    }
}