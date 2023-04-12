package by.tms.controller;

import by.tms.dto.UserDto;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

import static by.tms.utils.Constants.Attributes.CART_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FULL_PRICE;
import static by.tms.utils.Constants.RequestParameters.*;
import static by.tms.utils.ControllerUtils.createOrderNumber;

@Controller
@RequiredArgsConstructor
public class CardController {

    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;


    @GetMapping("/card")
    public String card(HttpServletRequest request) {
//        String login = request.getSession().getAttribute(USER_NAME).toString();
//        Long userId = userService.getUserId(login);
        HttpSession session = request.getSession(false);
        Long userId = ((UserDto) session.getAttribute("(USER_ACCESS_PERMISSION")).getId();
        List<ImmutablePair<Product, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        request.getServletContext().setAttribute(CART_PRODUCTS, cartProducts);
        request.getServletContext().setAttribute(FULL_PRICE, cartService.getProductsPrice(cartProducts));
        return "cart/shopping-cart";
//        return SHOPPING_CART_JSP_PAGE;
    }

    @PostMapping("/card-processing")
    public String cardProcessing(HttpServletRequest request) {
//        String login = getLogin(request);
//        Long userId = userService.getUserId(login);
        HttpSession session = request.getSession(false);
        Long userId = ((UserDto) session.getAttribute("(USER_ACCESS_PERMISSION")).getId();
        String path;
        String buyButton = request.getParameter(BUY);
        if (buyButton.equals(Constants.BUY)) {
            List<Product> products = cartService.getPurchasedProducts(userId, true, false);
            String orderNumber = "";
            while (!orderService.checkOrderNumber(orderNumber) || "".equals(orderNumber)) {
                orderNumber = createOrderNumber(userId);
            }
            orderService.createOrder(orderNumber, userId);
            String finalOrderNumber = orderNumber;
            products.forEach(product -> orderService.saveProductInOrderConfigurations(finalOrderNumber, product));
            cartService.deleteCartProductsAfterBuy(userId);
            path = "/cart/success-buy";
//            path = SUCCESS_BUY_JSP_PAGE;
        } else {
            path = "cart/shopping-cart";
//            path = SHOPPING_CART_PAGE;
        }
        return path;
    }

    @GetMapping("/add-card")
    public String addCard(
            HttpServletRequest request,
            @RequestParam Long productId,
            @RequestParam String shopFlag,
            @RequestParam String location) {
        String path;
//        Long id = Long.parseLong(request.getParameter(ID));
//        String shopFlag = request.getParameter(SHOP);
//        String location = request.getParameter(LOCATION);
//        String login = getLogin(request);
        HttpSession session = request.getSession(false);
        Long userId = ((UserDto) session.getAttribute("(USER_ACCESS_PERMISSION")).getId();
        cartService.addProductToCart(userId, productId, true, false);
//        cartService.addProductToCart(userService.getUserId(login), id, true, false);
        if (Objects.equals(shopFlag, TRUE)) {
            path = "shopping-cart";
//            path = SHOPPING_CART_PAGE;
        } else if (Objects.equals(location, FAVORITE)) {
            path = "favorites";
//            path = FAVORITES_PAGE;
        } else if (Objects.equals(location, SEARCH)) {
            path = "search?result=save";
//            path = SEARCH_SAVED_RESULT_PAGE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = "/product/" + productId;
//            path = PRODUCT_JSP_PAGE;
        } else {
            String productType = productService.getProductTypeValue(productId);
//            path = getPagePathByType(productType);
            path = "/products-page?type=" + productType;
        }
        return path;
    }


}
