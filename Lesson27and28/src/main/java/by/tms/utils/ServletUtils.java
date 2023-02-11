package by.tms.utils;

import by.tms.model.Product;
import lombok.experimental.UtilityClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

@UtilityClass
public class ServletUtils {
    public static void setAddressAndForward(HttpServletRequest req, HttpServletResponse resp, Long id, Collection<Product> products) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/products?type=" + products.stream()
                        .filter(product -> Objects.equals(product.getId(), id))
                        .findFirst()
                        .get()
                        .getType()
                        .toString()
                        .toLowerCase())
                .forward(req, resp);
    }

    public static void forwardToAddress(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }
}