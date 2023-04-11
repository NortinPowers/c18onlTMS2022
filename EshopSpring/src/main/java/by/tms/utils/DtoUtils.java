package by.tms.utils;

import by.tms.dto.ProductDto;
import by.tms.dto.UserDto;
import by.tms.model.Product;
import by.tms.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoUtils {

    public static ProductDto makeProductModelTransfer(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .info(product.getInfo())
                .name(product.getName())
//                         .type(makeProductTypeModelTransfer(product.getType()))
                .type(product.getType().getValue())
                .build();
    }

    public static UserDto makeUserModelTransfer(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .build();
    }

//    public static ProductTypeDto makeProductTypeModelTransfer(ProductType product) {
//        return ProductTypeDto.valueOf(product.getValue());
//    }
}
