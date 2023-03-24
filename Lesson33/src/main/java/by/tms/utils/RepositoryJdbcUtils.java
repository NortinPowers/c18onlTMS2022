package by.tms.utils;

import static by.tms.model.ProductType.getProductType;

import by.tms.model.Order;
import by.tms.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RepositoryJdbcUtils {

    public static void fillsValues(Collection<Product> products, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = getProduct(resultSet);
            products.add(product);
        }
    }

    public static Product getProductSimpleBuild(ResultSet resultSet) throws SQLException {
        return Product.builder()
                      .name(resultSet.getString("name"))
                      .info(resultSet.getString("info"))
                      .price(resultSet.getBigDecimal("price"))
                      .type(getProductType(resultSet.getString("type")))
                      .build();
    }

    public static Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = getProductSimpleBuild(resultSet);
        product.setId(resultSet.getLong("id"));
        product.setInfo(resultSet.getString("info"));
        return product;
    }

    public static Order getOrderBuild(ResultSet resultSet) throws SQLException {
        return Order.builder()
                    .id(resultSet.getString("id"))
                    .date(LocalDate.parse(resultSet.getString("date")))
                    .product(getProductSimpleBuild(resultSet))
                    .build();
    }

    public static Integer getModifyCount(boolean up, Integer productCount) {
//        if (up) {
//            productCount++;
//        } else {
//            productCount--;
//        }
//        return productCount;
        return up ? ++productCount : --productCount;
    }

    public static boolean isEmpty(Long productId, List<Product> products) {
        return products.stream()
                       .filter(product -> Objects.equals(product.getId(), productId))
                       .findAny()
                       .isEmpty();
    }
}