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

@WebServlet("/add-cart")
public class AddCartProductsServlet extends HttpServlet {
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
            String shopFlag = req.getParameter("shop");
            productService.addCartProduct(id);
            if (shopFlag == null) {
                String location = req.getParameter("location");
                if (location == null) {
                    setAddressAndForward(req, resp, id, productService);
                } else {
                    forwardToAddress(req, resp, "/view/favorites");
                }
            } else {
                forwardToAddress(req, resp, "/view/shopping-cart");
            }
        } catch (Exception e) {
            System.out.println("Exception (get-AddCPS): " + e.getMessage());
            forwardToAddress(req, resp, "/");
        }
    }
}