package by.tms.servlet;

import by.tms.service.ProductServiceAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.tms.utils.ServletUtils.forwardToAddress;
import static by.tms.utils.ServletUtils.setAddressAndForward;

@WebServlet("/add-favorite")
public class AddFavoriteProductsServlet extends HttpServlet {
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
            productService.addFavoriteProduct(id);
            setAddressAndForward(req, resp, id, productService.getFavoriteProducts());
        } catch (Exception e) {
            System.out.println("Exception (get-AddFPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}