package by.tms.eshop.utils;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.dto.UserDto;
import by.tms.eshop.model.Product;
import by.tms.eshop.model.ProductType;
import by.tms.eshop.model.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class DtoUtils {

    public static ProductDto makeProductDtoModelTransfer(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .info(product.getInfo())
                .name(product.getName())
                .type(product.getType().getValue())
                .build();
    }

    public static Product makeProductModelTransfer(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .price(productDto.getPrice())
                .info(productDto.getInfo())
                .name(productDto.getName())
                .type(ProductType.getProductType(productDto.getType()))
                .build();
    }

    public static UserDto makeUserDtoModelTransfer(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .build();
    }

    public static List<Product> getProductsFromDto(List<ProductDto> productsDto) {
        return productsDto.stream()
                .map(DtoUtils::makeProductModelTransfer)
                .toList();
    }
}