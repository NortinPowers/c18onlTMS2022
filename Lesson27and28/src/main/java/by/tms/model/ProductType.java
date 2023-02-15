package by.tms.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
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