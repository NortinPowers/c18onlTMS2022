package by.tms.controller;

import by.tms.dto.ProductDto;
import by.tms.service.CartService;
import by.tms.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.Attributes.FAVORITE_PRODUCTS;
import static by.tms.utils.Constants.RequestParameters.PRODUCT_PAGE;
import static by.tms.utils.Constants.RequestParameters.SEARCH;
import static by.tms.utils.ControllerUtils.getUserId;

@Controller
@RequiredArgsConstructor
public class FavoriteController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/favorites")
    public String favorites(HttpServletRequest request) {
//        String login = getLogin(request);
//        Long userId = userService.getUserId(login);
        Long userId = getUserId(request);
        List<ProductDto> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                .map(Pair::getLeft)
                .collect(Collectors.toList());
        request.getServletContext().setAttribute(FAVORITE_PRODUCTS, favoriteProducts);
        return "favorite/favorites";
    }

    @GetMapping("/add-favorite")
    public String addFavorite(HttpServletRequest request,
                              @RequestParam(name = "id") Long productId,
                              @RequestParam(name = "location") String location) {
//        String login = getLogin(request);
//        String path;
//        String location = request.getParameter(LOCATION);
//        Long id = Long.parseLong(request.getParameter(ID));
        cartService.addProductToCart(getUserId(request), productId, false, true);
//        cartService.addProductToCart(userService.getUserId(login), id, false, true);
        String productType = productService.getProductTypeValue(productId);
        return getPathFromAddFavoriteByParameters(productId, location, productType);
    }

    private static String getPathFromAddFavoriteByParameters(Long productId, String location, String productType) {
        String path;
        if (Objects.equals(location, SEARCH)) {
            path = "search/search?result=save";
//            path = SEARCH_SAVED_RESULT_PAGE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = "redirect:/product/" + productId;
//            path = PRODUCT_JSP_PAGE;
        } else {
            path = "redirect:/products-page?type=" + productType;
//            path = "/products-page?type=" + productType;
//            path = getPagePathByType(productType);
        }
        return path;
    }

    @GetMapping("/delete-favorite")
    public String deleteFavorite(HttpServletRequest request,
                                 @RequestParam(name = "id") Long productId) {
//        String login = getLogin(request);
//        Long id = Long.parseLong(request.getParameter(ID));
//        cartService.deleteProduct(userService.getUserId(login), id, false, true);
        cartService.deleteProduct(getUserId(request), productId, false, true);
        return "redirect:/favorites";
//        return FAVORITES_PAGE;
    }


//    private static Long getUserId(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        return ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
//    }
}
