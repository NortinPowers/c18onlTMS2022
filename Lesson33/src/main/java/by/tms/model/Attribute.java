package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Attribute {

    USER("user"),
    USER_NAME("userName"),
    USER_UUID("userUUID"),
    ORDERINGS("orderings"),
    INVALID("invalid"),
    FAVORITE_PRODUCTS("favoriteProducts"),
    ACCESS_PERMISSION("accessPermission"),
    PRODUCTS("products"),
    CART_PRODUCTS("cartProducts"),
    FULL_PRICE("fullPrice"),
    CONNECTION_POOL("connectionPool");

    private final String attribute;
}