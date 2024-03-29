package by.tms.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
    LOGIN_PAGE_POST_COMMAND("login-post"),
    CREATE_USER_PAGE_COMMAND("create-user"),
    CREATE_USER_PAGE_POST_COMMAND("create-user-post"),
    DELETE_CART_PRODUCT_PAGE_COMMAND("delete-cart-product"),
    DELETE_FAVORITE_PRODUCT_PAGE_COMMAND("delete-favorite-product"),
    FAVORITES_PAGE_COMMAND("favorites"),
    LOGOUT_PAGE_COMMAND("exit"),
    SHOPPING_CART_PAGE_COMMAND("shopping-cart"),
    SHOPPING_CART_PAGE_POST_COMMAND("shopping-cart-post"),
    SEARCH_PAGE_COMMAND("search"),
    SEARCH_PAGE_POST_COMMAND("search-post"),
    PRODUCT_PAGE_COMMAND("product"),
    FILTER_PAGE_COMMAND("filter");

    private final String command;
    private static final Map<String, Commands> commandsMapping = new HashMap<>();

    static {
        for (Commands command : values()) {
            commandsMapping.put(command.getCommand(), command);
        }
    }

    public static Commands fromString(String type) {
        return Optional.ofNullable(commandsMapping.get(type))
                       .orElseThrow(() -> new IllegalStateException("Unknown command type"));
    }
}