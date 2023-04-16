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
import static by.tms.utils.Constants.MappingPath.*;
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
        Long userId = getUserId(request);
        List<ImmutablePair<ProductDto, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        request.getServletContext().setAttribute(CART_PRODUCTS, cartProducts);
        request.getServletContext().setAttribute(FULL_PRICE, cartService.getProductsPrice(cartProducts));
        return SHOPPING_CART;
    }

    @PostMapping("/cart-processing")
    public String cardProcessing(HttpServletRequest request,
                                 @RequestParam String buy) {
        Long userId = getUserId(request);
        String path;
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
            path = SUCCESS_BUY;
        } else {
            path = REDIRECT_TO_CART;
        }
        return path;
    }

    @GetMapping("/add-cart")
    public String addCart(
            HttpServletRequest request,
            @RequestParam(name = ID) Long productId,
            @RequestParam(name = SHOP) String shopFlag,
            @RequestParam(name = LOCATION) String location) {
        Long userId = getUserId(request);
        cartService.addProductToCart(userId, productId, true, false);
        return getPathFromAddCartByParameters(productId, shopFlag, location);
    }

    private String getPathFromAddCartByParameters(Long productId, String shopFlag, String location) {
        String path;
        if (Objects.equals(shopFlag, TRUE)) {
            path = REDIRECT_TO_CART;
        } else if (Objects.equals(location, FAVORITE)) {
            path = REDIRECT_TO_FAVORITES;
        } else if (Objects.equals(location, SEARCH)) {
            path = REDIRECT_TO_SEARCH_RESULT_SAVE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = REDIRECT_TO_PRODUCT_WITH_PARAM + productId;
        } else {
            String productType = productService.getProductTypeValue(productId);
            path = REDIRECT_TO_PRODUCTS_PAGE_TYPE_WITH_PARAM + productType;
        }
        return path;
    }

    @GetMapping("/delete-cart")
    public String deleteCart(HttpServletRequest request,
                             @RequestParam(name = ID) Long productId) {
        cartService.deleteProduct(getUserId(request), productId, true, false);
        return REDIRECT_TO_CART;
    }
}