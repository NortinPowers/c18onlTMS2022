package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getCartService;
import static by.tms.utils.ServletUtils.getLogin;
import static by.tms.utils.ServletUtils.getProductService;
import static by.tms.utils.ServletUtils.getUserService;
import static by.tms.utils.ServletUtils.setAddressAndForward;

import by.tms.service.CartService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-cart")
public class AddCartServlet extends HttpServlet {

    private ProductService productService;
    private CartService cartService;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = getProductService(config);
        cartService = getCartService(config);
        userService = getUserService(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = getLogin(req);
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            String shopFlag = req.getParameter("shop");
            String location = req.getParameter("location");
            cartService.addProductToCart(userService.getUserId(login), id, true, false);
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