package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Commands {

    HOME_PAGE_COMMAND("home"),
    PRODUCTS_PAGE_COMMAND("products"),
    ACCOUNT_PAGE_COMMAND("account"),
    ADD_CART_PAGE_COMMAND("add-cart"),
    ADD_FAVORITE_PAGE_COMMAND("add-favorite"),
    LOGIN_PAGE_COMMAND("login"),
    CREATE_USER_PAGE_COMMAND("create-user"),
    DELETE_CART_PRODUCT_PAGE_COMMAND("delete-cart-product"),
    DELETE_FAVORITE_PRODUCT_PAGE_COMMAND("delete-favorite-product"),
    FAVORITES_PAGE_COMMAND("favorites"),
    LOGOUT_PAGE_COMMAND("exit"),
    SHOPPING_CART_PAGE_COMMAND("shopping-cart");

    private final String command;
}