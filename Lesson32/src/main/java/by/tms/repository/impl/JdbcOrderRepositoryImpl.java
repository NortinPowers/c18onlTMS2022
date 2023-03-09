package by.tms.repository.impl;

import by.tms.model.Order;
import by.tms.model.Product;
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

    private Connection connection;

    private static final String CREATE_ORDER = "insert into orders (id, date, user_id) values (?, ?, ?)";
    private static final String SAVE_PRODUCT_IN_ORDER = "insert into order_configurations (order_id, product_id) values (?, ?)";
    private static final String GET_ORDERS_BY_ID = "select o.id, o.date, p.name, p.info, p.price from orders o join order_configurations oc on o.id = oc.order_id join products p on p.id = oc.product_id where user_id=?";

    @Override
    public void createOrder(String order, Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_ORDER);
            statement.setString(1, order);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (createOrder): " + e.getMessage());
        }
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVE_PRODUCT_IN_ORDER);
            statement.setString(1, order);
            statement.setLong(2, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (saveProductInOrderConfigurations): " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersById(Long id) {
        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ORDERS_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(Order.builder()
                                .id(resultSet.getString("id"))
                                .date(LocalDate.parse(resultSet.getString("date")))
                                .product(Product.builder()
                                                .name(resultSet.getString("name"))
                                                .info(resultSet.getString("info"))
                                                .price(resultSet.getBigDecimal("price"))
                                                .build())
                                .build());
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getOrdersById): " + e.getMessage());
        }
        return orders;
    }
}