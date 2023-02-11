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
import java.util.Set;

import static by.tms.utils.ServletUtils.forwardToAddress;

@WebServlet("/view/favorites")
public class FavoriteProductsServlet extends HttpServlet {
    private ProductServiceAware productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Product> favoriteProducts = productService.getFavoriteProducts();
        req.getServletContext().setAttribute("favoriteProducts", favoriteProducts);
        forwardToAddress(req, resp, "/view/favorites.jsp");
    }
}