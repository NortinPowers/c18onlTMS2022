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
import java.util.List;

@WebServlet("/view/products")
public class ProductsServlet extends HttpServlet {
    private ProductServiceAware productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductServiceAware) config.getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProductsByType(req.getParameter("type"));
        req.getServletContext().setAttribute("products", products);
        req.getServletContext().getRequestDispatcher("/view/products.jsp").forward(req, resp);
    }
}