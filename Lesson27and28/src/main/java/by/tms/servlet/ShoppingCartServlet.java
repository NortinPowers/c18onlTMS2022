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

@WebServlet("/view/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {

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
        String login = req.getSession().getAttribute("userName").toString();
        Long userId = customerService.getUserId(login);
        List<Pair<Product, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        req.getServletContext().setAttribute("cartProducts", cartProducts);
        req.getServletContext().setAttribute("fullPrice", cartService.getProductsPrice(cartProducts));
        forwardToAddress(req, resp, "/view/shopping-cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buyButton = req.getParameter("buy");
        String login = getLogin(req);
        if (buyButton.equals("buy")) {
            cartService.deleteCartProductsAfterBuy(customerService.getUserId(login));
            forwardToAddress(req, resp, "/view/success-buy.jsp");
        } else {
            forwardToAddress(req, resp, "/view/shopping-cart");
        }
    }
}