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
import java.util.stream.Collectors;

import static by.tms.utils.Constants.Attributes.FAVORITE_PRODUCTS;
import static by.tms.utils.Constants.MappingPath.FAVORITES;
import static by.tms.utils.Constants.MappingPath.REDIRECT_TO_FAVORITES;
import static by.tms.utils.Constants.RequestParameters.ID;
import static by.tms.utils.Constants.RequestParameters.LOCATION;
import static by.tms.utils.ControllerUtils.getPathFromAddFavoriteByParameters;
import static by.tms.utils.ControllerUtils.getUserId;

@Controller
@RequiredArgsConstructor
public class FavoriteController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/favorites")
    public String favorites(HttpServletRequest request) {
        Long userId = getUserId(request);
        List<ProductDto> favoriteProducts = cartService.getProductsFromCart(userId, false, true).stream()
                .map(Pair::getLeft)
                .collect(Collectors.toList());
        request.getServletContext().setAttribute(FAVORITE_PRODUCTS, favoriteProducts);
        return FAVORITES;
    }

    @GetMapping("/add-favorite")
    public String addFavorite(HttpServletRequest request,
                              @RequestParam(name = ID) Long productId,
                              @RequestParam(name = LOCATION) String location) {
        cartService.addProductToCart(getUserId(request), productId, false, true);
        String productType = productService.getProductTypeValue(productId);
        return getPathFromAddFavoriteByParameters(productId, location, productType);
    }

    @GetMapping("/delete-favorite")
    public String deleteFavorite(HttpServletRequest request,
                                 @RequestParam(name = ID) Long productId) {
        cartService.deleteProduct(getUserId(request), productId, false, true);
        return REDIRECT_TO_FAVORITES;
    }
}