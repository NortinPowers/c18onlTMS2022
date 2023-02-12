package by.tms.utils;

import by.tms.model.User;
import lombok.experimental.UtilityClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@UtilityClass
public class ServletUtils {
    //    public static void setAddressAndForward(HttpServletRequest req, HttpServletResponse resp, Long id, Collection<Product> products) throws ServletException, IOException {
//        req.getServletContext().getRequestDispatcher("/view/products?type=" + products.stream()
//                        .filter(product -> Objects.equals(product.getId(), id))
//                        .findFirst()
//                        .get()
//                        .getType()
//                        .toString()
//                        .toLowerCase())
//                .forward(req, resp);
//    }
    public static void setAddressAndForward(HttpServletRequest req, HttpServletResponse resp, String type) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/view/products?type=" + type).forward(req, resp);
    }

    public static void forwardToAddress(HttpServletRequest req, HttpServletResponse resp, String address) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(address).forward(req, resp);
    }


    public static void saveUserSession(HttpServletRequest req, String login) {
        HttpSession session = req.getSession();
        session.setAttribute("accessPermission", new User(login));
        session.setAttribute("userName", login);
    }
}