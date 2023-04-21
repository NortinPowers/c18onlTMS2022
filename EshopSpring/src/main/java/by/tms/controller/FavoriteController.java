package by.tms.controller;

import by.tms.service.CartService;
import by.tms.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView showFavoritesPage(HttpSession session) {
        Long userId = getUserId(session);
        ModelMap modelMap = new ModelMap(FAVORITE_PRODUCTS, cartService.getProductsFromCart(userId, false, true).stream()
                .map(Pair::getLeft)
                .collect(Collectors.toList()));
        return new ModelAndView(FAVORITES, modelMap);
    }

    @GetMapping("/add-favorite")
    public ModelAndView addProductToFavorite(HttpSession session,
                                             @RequestParam(name = ID) Long productId,
                                             @RequestParam(name = LOCATION) String location) {
        Long userId = getUserId(session);
        cartService.addProductToCart(userId, productId, false, true);
        return new ModelAndView(getPathFromAddFavoriteByParameters(productId, location, productService.getProductTypeValue(productId)));
    }

    @GetMapping("/delete-favorite")
    public ModelAndView deleteProductFromFavorite(HttpSession session,
                                                  @RequestParam(name = ID) Long productId) {
        cartService.deleteProduct(getUserId(session), productId, false, true);
        return new ModelAndView(REDIRECT_TO_FAVORITES);
    }
}