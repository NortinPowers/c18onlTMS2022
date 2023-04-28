package by.tms.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductType {
    PHONE("phone"),
    TV("tv");

    private final String value;

    public static ProductType getProductType(String type) {
        for (ProductType productType : ProductType.values()) {
            if (productType.value.equals(type)) {
                return productType;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + type);
    }
}