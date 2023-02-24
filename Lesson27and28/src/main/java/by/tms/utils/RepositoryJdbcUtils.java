package by.tms.utils;

import by.tms.model.Product;
import by.tms.model.ProductType;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static by.tms.model.ProductType.getProductType;

@UtilityClass
public class RepositoryJdbcUtils {

    public static void fillsValues(List<Product> products, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            BigDecimal price = resultSet.getBigDecimal("price");
            String type = resultSet.getString("type");
            ProductType productType = getProductType(type);
            String info = resultSet.getString("info");
            products.add(new Product(id, name, price, productType, info));
        }
    }

    public static Integer getModifyCount(boolean up, Integer productCount) {
        if (up) {
            productCount++;
        } else {
            productCount--;
        }
        return productCount;
    }

    public static boolean isEmpty(Long productId, List<Product> products) {
        return products.stream()
                       .filter(product -> Objects.equals(product.getId(), productId))
                       .findAny()
                       .isEmpty();
    }
}