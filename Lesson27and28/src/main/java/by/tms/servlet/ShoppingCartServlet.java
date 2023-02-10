package by.tms.servlet;

import by.tms.model.Product;
import by.tms.service.ProductServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/view/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    private ProductServiceAware productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> cartProducts = productService.getCartProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
        req.getServletContext().setAttribute("cartProducts", cartProducts);
        req.getServletContext().setAttribute("full_price", productService.getProductsPrice(cartProducts));
        req.getServletContext().getRequestDispatcher("/view/shopping-cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buyButton = req.getParameter("buy");
        if (buyButton.equals("buy")) {
            productService.clearProductsCart();
            req.getServletContext().getRequestDispatcher("/success-buy.jsp").forward(req, resp);
        } else {
            req.getServletContext().getRequestDispatcher("/shopping-cart").forward(req, resp);
        }
    }
}