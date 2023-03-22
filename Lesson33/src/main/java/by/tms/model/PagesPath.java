package by.tms.model;

import by.tms.utils.ControllerUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PagesPath {

    HOME_PAGE("eshop.jsp"),
    ESHOP_PAGE("eshop"),
    PRODUCTS_PAGE("view/products.jsp"),
    TV_PRODUCTS_PAGE(ControllerUtils.getPathByType(ProductType.TV.getValue())),
    PHONE_PRODUCTS_PAGE(ControllerUtils.getPathByType(ProductType.PHONE.getValue())),
    ACCOUNT_PAGE("view/account.jsp"),
    SHOPPING_CART_PAGE("eshop?command=shopping-cart"),
    SHOPPING_CART_JSP_PAGE("view/shopping-cart.jsp"),
    FAVORITES_PAGE("eshop?command=favorites"),
    FAVORITES_JSP_PAGE("view/favorites.jsp"),
    SUCCESS_REGISTER_PAGE("view/success-register.jsp"),
    FAIL_REGISTER_PAGE("view/fail-register.jsp"),
    LOGIN_PAGE("login"),
    LOGIN_JSP_PAGE("login.jsp"),
    SUCCESS_BUY_JSP_PAGE("view/success-buy.jsp");

    private final String path;
}