package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.model.Product;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.utils.Constants;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

import static by.tms.utils.Constants.Attributes.CART_PRODUCTS;
import static by.tms.utils.Constants.Attributes.FULL_PRICE;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_CART;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_FAVORITES;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_PRODUCTS_PAGE_TYPE_WITH_PARAM;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_PRODUCT_WITH_PARAM;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_SEARCH_RESULT_SAVE;
import static by.tms.utils.Constants.MappingPath.SHOPPING_CART;
import static by.tms.utils.Constants.MappingPath.SUCCESS_BUY;
import static by.tms.utils.Constants.RequestParameters.FAVORITE;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.LOCATION;
import static by.tms.utils.Constants.RequestParameters.PRODUCT_PAGE;
import static by.tms.utils.Constants.RequestParameters.SEARCH;
import static by.tms.utils.Constants.RequestParameters.SHOP;
import static by.tms.utils.Constants.RequestParameters.TRUE;
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
    public ModelAndView showCardPage(HttpSession session, ModelAndView modelAndView) {
        Long userId = getUserId(session);
        List<ImmutablePair<ProductDto, Integer>> cartProducts = cartService.getProductsFromCart(userId, true, false);
        modelAndView.addObject(CART_PRODUCTS, cartService.getProductsFromCart(userId, true, false));
        modelAndView.addObject(FULL_PRICE, cartService.getProductsPrice(cartProducts));
        modelAndView.setViewName(SHOPPING_CART);
        return modelAndView;
    }

    @PostMapping("/cart-processing")
    public ModelAndView showCardProcessingPage(HttpSession session,
                                               @RequestParam String buy,
                                               ModelAndView modelAndView) {
        Long userId = getUserId(session);
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
            modelAndView.setViewName(SUCCESS_BUY);
        } else {
            modelAndView.setViewName(REDIRECT_TO_CART);
        }
        return modelAndView;
    }

    @GetMapping("/add-cart")
    public ModelAndView AddProductToCart(HttpSession session,
                                         @RequestParam(name = ID) Long productId,
                                         @RequestParam(name = SHOP) String shopFlag,
                                         @RequestParam(name = LOCATION) String location) {
        Long userId = getUserId(session);
        cartService.addProductToCart(userId, productId, true, false);
        return new ModelAndView(getPathFromAddCartByParameters(productId, shopFlag, location));
    }

    @GetMapping("/delete-cart")
    public ModelAndView deleteProductFromCart(HttpSession session,
                                              @RequestParam(name = ID) Long productId) {
        cartService.deleteProduct(getUserId(session), productId, true, false);
        return new ModelAndView(REDIRECT_TO_CART);
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
}