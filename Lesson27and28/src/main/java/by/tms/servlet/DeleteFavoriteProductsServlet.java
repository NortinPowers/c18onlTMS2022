package by.tms.servlet;

import by.tms.service.ProductServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-favorite")
public class DeleteFavoriteProductsServlet extends HttpServlet {
    private ProductServiceAware productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(req.getParameter("id"));
            productService.deleteFavoriteProduct(id);
            req.getServletContext().getRequestDispatcher("/view/favorites").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Exception (get-DelFPS): " + e.getMessage());
            req.getServletContext().getRequestDispatcher("/view/favorites").forward(req, resp);
        }
    }
}