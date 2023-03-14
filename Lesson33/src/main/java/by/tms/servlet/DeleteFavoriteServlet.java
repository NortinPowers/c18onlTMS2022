package by.tms.servlet;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.getCartService;
import static by.tms.utils.ServletUtils.getLogin;
import static by.tms.utils.ServletUtils.getUserService;

import by.tms.service.CartService;
import by.tms.service.UserService;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-favorite")
public class DeleteFavoriteServlet extends HttpServlet {

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
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            cartService.deleteProduct(userService.getUserId(login), id, false, true);
        } catch (Exception e) {
            System.out.println("Exception (get-DelFPS): " + e.getMessage());
        }
        forwardToAddress(req, resp, "/view/favorites");
    }
}