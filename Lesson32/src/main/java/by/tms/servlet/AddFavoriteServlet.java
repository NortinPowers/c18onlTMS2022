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
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-favorite")
public class AddFavoriteServlet extends HttpServlet {

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
            cartService.addProductToCart(userService.getUserId(login), id, false, true);
            setAddressAndForward(req, resp, productService.getProductTypeValue(id));
        } catch (Exception e) {
            System.out.println("Exception (get-AddFPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}