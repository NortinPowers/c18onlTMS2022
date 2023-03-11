package by.tms.repository.impl;

import static by.tms.model.ProductType.getProductType;

import by.tms.model.Order;
import by.tms.model.Product;
import by.tms.model.ProductType;
import by.tms.repository.ConnectionPool;
import by.tms.repository.JdbcOrderRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcOrderRepositoryImpl implements JdbcOrderRepository {

    private ConnectionPool connectionPool;

    private static final String CREATE_ORDER = "insert into orders (id, date, user_id) values (?, ?, ?)";
    private static final String SAVE_PRODUCT_IN_ORDER = "insert into order_configurations (order_id, product_id) values (?, ?)";
    private static final String GET_ORDERS_BY_ID = "select o.id, o.date, p.name, p.info, p.price, p.type from orders o join order_configurations oc on o.id = oc.order_id join products p on p.id = oc.product_id where user_id=?";

    @Override
    public void createOrder(String order, Long id) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_ORDER);
            statement.setString(1, order);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (createOrder()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (createOrder().connectionPool.getConnection): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (createOrder().connectionPool): " + e.getMessage());
            }
        }
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE_PRODUCT_IN_ORDER);
            statement.setString(1, order);
            statement.setLong(2, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (saveProductInOrderConfigurations()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (saveProductInOrderConfigurations().connectionPool.getConnection): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (saveProductInOrderConfigurations().connectionPool): " + e.getMessage());
            }
        }
    }

    @Override
    public List<Order> getOrdersById(Long id) {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ORDERS_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String type = resultSet.getString("type");
                ProductType productType = getProductType(type);
                orders.add(Order.builder()
                                .id(resultSet.getString("id"))
                                .date(LocalDate.parse(resultSet.getString("date")))
                                .product(Product.builder()
                                                .name(resultSet.getString("name"))
                                                .info(resultSet.getString("info"))
                                                .price(resultSet.getBigDecimal("price"))
                                                .type(productType)
                                                .build())
                                .build());
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getOrdersById()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (getOrdersById().connectionPool.getConnection): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (getOrdersById().connectionPool): " + e.getMessage());
            }
        }
        return orders;
    }
}