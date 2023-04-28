package by.tms.eshop.utils;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.model.Product;
import lombok.experimental.UtilityClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static by.tms.eshop.model.ProductType.getProductType;
import static by.tms.eshop.utils.Constants.ALL;

@UtilityClass
public class RepositoryJdbcUtils {

    public static ProductDto getProductSimpleBuild(ResultSet resultSet) throws SQLException {
        Product product = Product.builder()
                .name(resultSet.getString("name"))
                .info(resultSet.getString("info"))
                .price(resultSet.getBigDecimal("price"))
                .type(getProductType(resultSet.getString("type")))
                .build();
        return DtoUtils.makeProductDtoModelTransfer(product);
    }

    public static ProductDto getProductDto(ResultSet resultSet) throws SQLException {
        ProductDto productDto = getProductSimpleBuild(resultSet);
        productDto.setId(resultSet.getLong("id"));
        productDto.setInfo(resultSet.getString("info"));
        return productDto;
    }

    public static Integer getModifyCount(boolean up, Integer productCount) {
        return up ? ++productCount : --productCount;
    }

    public static boolean isProductNotIncluded(Long productId, List<ProductDto> products) {
        return products.stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findAny()
                .isEmpty();
    }

    public static String getQueryDependType(String type, String query) {
        String fullQuery;
        if (!ALL.equals(type)) {
            fullQuery = query + " and pt.type='" + type + "' order by p.id";
        } else {
            fullQuery = query + " order by p.id";
        }
        return fullQuery;
    }
}