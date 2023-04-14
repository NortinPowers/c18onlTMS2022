package by.tms.utils;

import by.tms.dto.ProductDto;
import by.tms.model.Product;
import lombok.experimental.UtilityClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static by.tms.model.ProductType.getProductType;
import static by.tms.utils.Constants.ALL;

@UtilityClass
public class RepositoryJdbcUtils {

//    public static void fillsCollectionValues(Collection<ProductDto> products, PreparedStatement statement) throws SQLException {
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            Product product = getProduct(resultSet);
//            ProductDto productDto = makeProductDtoModelTransfer(product);
//            products.add(productDto);
//        }
//    }

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

    //
//    public static Order getOrderBuild(ResultSet resultSet) throws SQLException {
//        return Order.builder()
//                    .id(resultSet.getString("id"))
//                    .date(LocalDate.parse(resultSet.getString("date")))
//                    .product(getProductSimpleBuild(resultSet))
//                    .build();
//    }
//
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
//
//    public static void fillsSet(String searchCondition, Set<Product> products, PreparedStatement statement) throws SQLException {
//        statement.setString(1, "%" + searchCondition + "%");
//        ResultSet resultSetByName = statement.executeQuery();
//        while (resultSetByName.next()) {
//            Product product = getProduct(resultSetByName);
//            products.add(product);
//        }
//    }
}