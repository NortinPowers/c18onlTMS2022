package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String BUY = "buy";
    public static final String CONVERSATION = "conversation";
    public static final String PATH_TO_PRODUCT_TYPE = "/eshop?command=products&type=";
    public static final String SAVE = "save";
    public static final String ALL = "all";
    public static final String TRUE = "true";

    @UtilityClass
    public class Mapping {
        public static final String ESHOP = "home/eshop";
        public static final String PRODUCTS = "product/products";
        public static final String PRODUCT = "product/product";
        public static final String LOGIN = "login/login";


    }

    @UtilityClass
    public class Attributes {

        public static final String USER = "user";
        public static final String USER_NAME = "userName";
        public static final String USER_UUID = "userUUID";
        public static final String ORDERINGS = "orderings";
        public static final String INVALID = "invalid";
        public static final String FAVORITE_PRODUCTS = "favoriteProducts";
        public static final String USER_ACCESS_PERMISSION = "userAccessPermission";
        public static final String PRODUCTS = "products";
        public static final String FOUND_PRODUCTS = "foundProducts";
        public static final String FILTER_FOUND_PRODUCTS = "filterFoundProducts";
        public static final String CART_PRODUCTS = "cartProducts";
        public static final String FULL_PRICE = "fullPrice";
        public static final String ONE_PRODUCT = "oneProduct";
    }

    @UtilityClass
    public class RequestParameters {

        public static final String COMMAND = "command";
        public static final String TYPE = "type";
        public static final String FAVORITE = "favorite";
        public static final String SEARCH = "search";
        public static final String PRODUCT_PAGE = "product-page";
        public static final String TRUE = "true";
        public static final String ID = "id";
        public static final String SHOP = "shop";
        public static final String LOCATION = "location";
        public static final String LOGIN = "login";
        public static final String PASSWORD = "password";
        public static final String VERIFY_PASSWORD = "verify-password";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String EMAIL = "email";
        public static final String BIRTHDAY = "birthday";
        public static final String BUY = "buy";
        public static final String SEARCH_CONDITION = "search-condition";
        public static final String RESULT = "result";
        public static final String FILTER = "filter";
        public static final String MIN_PRICE = "min-price";
        public static final String MAX_PRICE = "max-price";
        public static final String SELECT = "select";
    }
}