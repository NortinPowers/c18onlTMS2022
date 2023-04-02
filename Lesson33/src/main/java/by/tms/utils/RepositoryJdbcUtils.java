package by.tms.utils;

import static by.tms.model.ProductType.getProductType;
import static by.tms.utils.Constants.ALL;

import by.tms.model.Order;
import by.tms.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RepositoryJdbcUtils {

    public static void fillsCollectionValues(Collection<Product> products, PreparedStatement statement) throws SQLException {
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
        return up ? ++productCount : --productCount;
    }

    public static boolean isEmpty(Long productId, List<Product> products) {
        return products.stream()
                       .filter(product -> Objects.equals(product.getId(), productId))
                       .findAny()
                       .isEmpty();
    }

    public static String getQueryDependType(String type, String query, String baseMark) {
        String fullQuery;
        if (!ALL.equals(type)) {
            fullQuery = query + " and p.type='" + type + "' order by " + baseMark + ".id";
        } else {
            fullQuery = query + " order by " + baseMark + ".id";
        }
        return fullQuery;
    }

    public static void fillsSet(String searchCondition, Set<Product> products, PreparedStatement statement) throws SQLException {
//        statement.setString(1, String.format("%s searchCondition %s", "%", "%"));
        statement.setString(1, "%" + searchCondition + "%");
        ResultSet resultSetByName = statement.executeQuery();
        while (resultSetByName.next()) {
            Product product = Product.builder()
                                     .id(resultSetByName.getLong("id"))
                                     .build();
            products.add(product);
        }
    }
}