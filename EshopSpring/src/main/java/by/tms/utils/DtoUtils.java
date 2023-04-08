package by.tms.utils;

import by.tms.dto.ProductDto;
import by.tms.dto.ProductTypeDto;
import by.tms.model.Product;
import by.tms.model.ProductType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoUtils {

    public static ProductDto makeProductModelTransfer(Product product) {
        return ProductDto.builder()
                         .id(product.getId())
                         .price(product.getPrice())
                         .info(product.getInfo())
                         .name(product.getName())
                         .type(makeProductTypeModelTransfer(product.getType()))
                         .build();
    }

    public static ProductTypeDto makeProductTypeModelTransfer(ProductType product) {
        return ProductTypeDto.valueOf(product.getValue());
    }
}
