package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String BUY = "buy";
    public static final String CONVERSATION = "conversation";
    public static final String SAVE = "save";
    public static final String ALL = "all";
    public static final String TRUE = "true";

    @UtilityClass
    public class MappingPath {

        public static final String ESHOP = "home/eshop";
        public static final String PRODUCTS = "product/products";
        public static final String PRODUCT = "product/product";
        public static final String LOGIN = "login/login";
        public static final String CREATE_USER = "login/create-user";
        public static final String SUCCESS_REGISTER = "login/success-register";
        public static final String FAIL_REGISTER = "login/fail-register";
        public static final String ACCOUNT = "account/account";
        public static final String SEARCH_PATH = "search/search";
        public static final String SHOPPING_CART = "cart/shopping-cart";
        public static final String FAVORITES = "favorite/favorites";
        public static final String SUCCESS_BUY = "cart/success-buy";
        public static final String ERROR_500 = "error/500";
        public static final String ERROR_404 = "error/404";
        public static final String SOME_ERROR = "error/some-error";
        public static final String REDIRECT_TO_CART = "redirect:/cart";
        public static final String REDIRECT_TO_FAVORITES = "redirect:/favorites";
        public static final String REDIRECT_TO_SEARCH_RESULT_SAVE = "redirect:/search?result=save";
        public static final String REDIRECT_TO_SEARCH_FILTER_TRUE_RESULT_SAVE = "redirect:/search?filter=true&result=save";
        public static final String REDIRECT_TO_PRODUCT_WITH_PARAM = "redirect:/product/";
        public static final String REDIRECT_TO_PRODUCTS_PAGE_TYPE_WITH_PARAM = "redirect:/products-page?type=";
    }

    @UtilityClass
    public class Attributes {

        public static final String USER_DTO = "userDto";
        public static final String USER_NAME = "userName";
        public static final String USER_UUID = "userUUID";
        public static final String USER_ORDER = "userOrder";
        public static final String INVALID = "invalid";
        public static final String FAVORITE_PRODUCTS = "favoriteProducts";
        public static final String USER_ACCESS_PERMISSION = "userAccessPermission";
        public static final String PRODUCTS = "products";
        public static final String PRODUCT = "product";
        public static final String FOUND_PRODUCTS = "foundProducts";
        public static final String FILTER_FOUND_PRODUCTS = "filterFoundProducts";
        public static final String CART_PRODUCTS = "cartProducts";
        public static final String FULL_PRICE = "fullPrice";
    }

    @UtilityClass
    public class RequestParameters {

        public static final String TYPE = "type";
        public static final String FAVORITE = "favorite";
        public static final String SEARCH = "search";
        public static final String PRODUCT_PAGE = "product-page";
        public static final String TRUE = "true";
        public static final String ID = "id";
        public static final String SHOP = "shop";
        public static final String LOCATION = "location";
        public static final String SEARCH_CONDITION = "search-condition";
        public static final String FILTER = "filter";
        public static final String MIN_PRICE = "min-price";
        public static final String MAX_PRICE = "max-price";
        public static final String SELECT = "select";
    }
}