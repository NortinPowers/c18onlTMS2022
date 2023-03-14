package by.tms.servlet;

import static by.tms.utils.ServletUtils.createOrderNumber;
import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getCartService;
import static by.tms.utils.ServletUtils.getLogin;
import static by.tms.utils.ServletUtils.getOrderService;
import static by.tms.utils.ServletUtils.getUserService;

import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.OrderService;
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

@WebServlet("/view/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

    private CartService cartService;
    private UserService userService;
    private OrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartService = getCartService(config);
        userService = getUserService(config);
        orderService = getOrderService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getSession().getAttribute("userName").toString();
        Long userId = userService.getUserId(login);
        List<Pair<Product, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        req.getServletContext().setAttribute("cartProducts", cartProducts);
        req.getServletContext().setAttribute("fullPrice", cartService.getProductsPrice(cartProducts));
        forwardToAddress(req, resp, "/view/shopping-cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buyButton = req.getParameter("buy");
        String login = getLogin(req);
        Long userId = userService.getUserId(login);
        if ("buy".equals(buyButton)) {
            List<Product> products = cartService.getPurchasedProducts(userId, true, false);
            String number = createOrderNumber(userId, products);
            orderService.createOrder(number, userId);
            products.forEach(product -> orderService.saveProductInOrderConfigurations(number, product));
            cartService.deleteCartProductsAfterBuy(userId);
            forwardToAddress(req, resp, "/view/success-buy.jsp");
        } else {
            forwardToAddress(req, resp, "/view/shopping-cart");
        }
    }
}