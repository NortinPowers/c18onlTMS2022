package by.tms.model;

import static by.tms.model.ProductType.PHONE;
import static by.tms.model.ProductType.TV;
import static by.tms.utils.ControllerUtils.getPathByType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PagesPath {

    HOME_PAGE("eshop.jsp"),
    ESHOP_PAGE("eshop"),
    PRODUCTS_PAGE("view/products.jsp"),
    TV_PRODUCTS_PAGE(getPathByType(TV.getValue())),
    PHONE_PRODUCTS_PAGE(getPathByType(PHONE.getValue())),
    ACCOUNT_PAGE("view/account.jsp"),
    SHOPPING_CART_PAGE("eshop?command=shopping-cart"),
    SHOPPING_CART_JSP_PAGE("view/shopping-cart.jsp"),
    FAVORITES_PAGE("eshop?command=favorites"),
    FAVORITES_JSP_PAGE("view/favorites.jsp"),
    SUCCESS_REGISTER_PAGE("view/success-register.jsp"),
    FAIL_REGISTER_PAGE("view/fail-register.jsp"),
    LOGIN_PAGE("login"),
    LOGIN_JSP_PAGE("login.jsp"),
    SUCCESS_BUY_JSP_PAGE("view/success-buy.jsp"),
    SEARCH_JSP_PAGE("view/search.jsp"),
    SEARCH_PAGE("eshop?command=search"),
    SEARCH_SAVED_RESULT_PAGE("eshop?command=search&result=save"),
    SEARCH_FILTER_RESULT_PAGE("eshop?command=search&filter=true&result=save"),
    SEARCH_ALL_RESULT_PAGE("eshop?command=search&result=save"),
    PRODUCT_JSP_PAGE("view/oneProduct.jsp");

    private final String path;
}