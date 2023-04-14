package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
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
import static by.tms.utils.ControllerUtils.getUserId;
import static by.tms.utils.DtoUtils.getProductsFromDto;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;


    @GetMapping("/cart")
    public String card(HttpServletRequest request) {
//        String login = request.getSession().getAttribute(USER_NAME).toString();
//        Long userId = userService.getUserId(login);
//        HttpSession session = request.getSession(false);
//        Long userId = ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
        Long userId = getUserId(request);
        List<ImmutablePair<ProductDto, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        request.getServletContext().setAttribute(CART_PRODUCTS, cartProducts);
        request.getServletContext().setAttribute(FULL_PRICE, cartService.getProductsPrice(cartProducts));
        return "cart/shopping-cart";
//        return SHOPPING_CART_JSP_PAGE;
    }

    @PostMapping("/cart-processing")
    public String cardProcessing(HttpServletRequest request,
                                 @RequestParam String buy) { //value?! not name
//        String login = getLogin(request);
//        Long userId = userService.getUserId(login);
//        HttpSession session = request.getSession(false);
//        Long userId = ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
        Long userId = getUserId(request);
        String path;
//        String buyButton = request.getParameter(BUY);
        if (buy.equalsIgnoreCase(Constants.BUY)) {
            List<ProductDto> productsDto = cartService.getPurchasedProducts(userId, true, false);
            String orderNumber = "";
            while (orderService.checkOrderNumber(orderNumber) || "".equals(orderNumber)) {
                orderNumber = createOrderNumber(userId);
            }
            orderService.createOrder(orderNumber, userId);
            List<Product> products = getProductsFromDto(productsDto);
            String finalOrderNumber = orderNumber;
            products.forEach(product -> orderService.saveProductInOrderConfigurations(finalOrderNumber, product));
            cartService.deleteCartProductsAfterBuy(userId);
            path = "cart/success-buy";
//            path = SUCCESS_BUY_JSP_PAGE;
        } else {
            path = "redirect:/cart";
//            path = SHOPPING_CART_PAGE;
        }
        return path;
    }


    @GetMapping("/add-cart")
    public String addCart(
            HttpServletRequest request,
            @RequestParam(name = "id") Long productId,
            @RequestParam(name = "shop") String shopFlag,
            @RequestParam(name = "location") String location) {
//        String path;
//        Long id = Long.parseLong(request.getParameter(ID));
//        String shopFlag = request.getParameter(SHOP);
//        String location = request.getParameter(LOCATION);
//        String login = getLogin(request);
//        HttpSession session = request.getSession(false);
//        Long userId = ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
        Long userId = getUserId(request);
        cartService.addProductToCart(userId, productId, true, false);
//        cartService.addProductToCart(userService.getUserId(login), id, true, false);
        return getPathFromAddCartByParameters(productId, shopFlag, location);
    }

    private String getPathFromAddCartByParameters(Long productId, String shopFlag, String location) {
        String path;
        if (Objects.equals(shopFlag, TRUE)) {
            path = "redirect:/cart";
//            path = SHOPPING_CART_PAGE;
        } else if (Objects.equals(location, FAVORITE)) {
            path = "redirect:/favorites";
//            path = FAVORITES_PAGE;
        } else if (Objects.equals(location, SEARCH)) {
            path = "redirect:/search?result=save";
//            path = SEARCH_SAVED_RESULT_PAGE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = "redirect:/product/" + productId;
//            path = PRODUCT_JSP_PAGE;
        } else {
            String productType = productService.getProductTypeValue(productId);
//            path = getPagePathByType(productType);
            path = "redirect:/products-page?type=" + productType;
        }
        return path;
    }

    @GetMapping("/delete-cart")
    public String deleteCart(HttpServletRequest request,
                             @RequestParam(name = "id") Long productId) {
//        String login = getLogin(request);
//        Long id = Long.parseLong(request.getParameter(ID));
//        cartService.deleteProduct(userService.getUserId(login), id, true, false);
        cartService.deleteProduct(getUserId(request), productId, true, false);
//        return SHOPPING_CART_PAGE;
        return "redirect:/cart";
    }
}
