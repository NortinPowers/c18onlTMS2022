package by.tms.repository.impl;

import by.tms.mapper.OrderMapper;
import by.tms.model.Product;
import by.tms.repository.JdbcOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Slf4j
@Repository
@RequiredArgsConstructor
@Lazy
public class JdbcOrderRepositoryImpl implements JdbcOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String CREATE_ORDER = "insert into orders (id, date, user_id) values (?, ?, ?)";
    private static final String SAVE_PRODUCT_IN_ORDER = "insert into order_configurations (order_id, product_id) values (?, ?)";
    private static final String GET_ORDERS_BY_ID = "select o.id, o.date, p.name, p.info, p.price, p.type from orders o join order_configurations oc on o.id = oc.order_id join products p on p.id = oc.product_id where user_id=?";
    private static final String GET_ORDERS_NUMBER = "select id from orders where id=?";

    @Override
    public void createOrder(String order, Long id) {
        jdbcTemplate.update(CREATE_ORDER, order, Date.valueOf(LocalDate.now()), id);

//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(CREATE_ORDER)) {
//            statement.setString(1, order);
//            statement.setDate(2, Date.valueOf(LocalDate.now()));
//            statement.setLong(3, id);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            log.error("Exception (createOrder()): ", e);
//        }
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        jdbcTemplate.update(SAVE_PRODUCT_IN_ORDER, order, product.getId());

//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(SAVE_PRODUCT_IN_ORDER)) {
//            statement.setString(1, order);
//            statement.setLong(2, product.getId());
//            statement.executeUpdate();
//        } catch (Exception e) {
//            log.error("Exception (saveProductInOrderConfigurations()): ", e);
//        }
    }

//    @Override
//    public List<Order> getOrdersById(Long id) {
//        List<Order> orders = new ArrayList<>();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ORDERS_BY_ID)) {
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                orders.add(RepositoryJdbcUtils.getOrderBuild(resultSet));
//            }
//        } catch (Exception e) {
//            log.error("Exception (getOrdersById()): ", e);
//        }
//        return orders;
//    }

    @Override
    public boolean checkOrderNumber(String number) {
        return jdbcTemplate.query(GET_ORDERS_NUMBER, new OrderMapper(), number).stream()
                .findAny()
                .isPresent();
//        boolean unique = false;
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ORDERS_NUMBER)) {
//            statement.setString(1, number);
//            ResultSet resultSet = statement.executeQuery();
//            if (!resultSet.next()) {
//                unique = true;
//            }
//        } catch (Exception e) {
//            log.error("Exception (checkOrderNumber()): ", e);
//        }
//        return unique;
    }
}