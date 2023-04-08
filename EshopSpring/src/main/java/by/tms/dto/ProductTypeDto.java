package by.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductTypeDto {
    PHONE("phone"),
    TV("tv");

    private final String value;

    public static ProductTypeDto getProductType(String type) {
        for (ProductTypeDto productType : ProductTypeDto.values()) {
            if (productType.value.equals(type)) {
                return productType;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + type);
    }
}