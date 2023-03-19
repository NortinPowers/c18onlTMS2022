package by.tms.repository.impl;

import by.tms.model.Order;
import by.tms.model.Product;
import by.tms.repository.ConnectionPool;
import by.tms.repository.ConnectionWrapper;
import by.tms.repository.JdbcOrderRepository;
import by.tms.utils.RepositoryJdbcUtils;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class JdbcOrderRepositoryImpl implements JdbcOrderRepository {

    private ConnectionPool connectionPool;

    private static final String CREATE_ORDER = "insert into orders (id, date, user_id) values (?, ?, ?)";
    private static final String SAVE_PRODUCT_IN_ORDER = "insert into order_configurations (order_id, product_id) values (?, ?)";
    private static final String GET_ORDERS_BY_ID = "select o.id, o.date, p.name, p.info, p.price, p.type from orders o join order_configurations oc on o.id = oc.order_id join products p on p.id = oc.product_id where user_id=?";

    @Override
    public void createOrder(String order, Long id) {
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(CREATE_ORDER)) {
            statement.setString(1, order);
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setLong(3, id);
            statement.executeUpdate();
        } catch (Exception e) {
            log.error("Exception (createOrder()): " + e);
        }
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(SAVE_PRODUCT_IN_ORDER)) {
            statement.setString(1, order);
            statement.setLong(2, product.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            log.error("Exception (saveProductInOrderConfigurations()): " + e);
        }
    }

    @Override
    public List<Order> getOrdersById(Long id) {
        List<Order> orders = new ArrayList<>();
        try (ConnectionWrapper connectionWrapper = connectionPool.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ORDERS_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(RepositoryJdbcUtils.getOrderBuild(resultSet));
            }
        } catch (Exception e) {
            log.error("Exception (getOrdersById()): " + e);
        }
        return orders;
    }
}