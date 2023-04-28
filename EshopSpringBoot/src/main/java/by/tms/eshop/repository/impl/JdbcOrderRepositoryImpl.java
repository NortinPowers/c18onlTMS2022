package by.tms.eshop.repository.impl;

import by.tms.eshop.dto.OrderFullParamDto;
import by.tms.eshop.mapper.OrderFullParamDtoMapper;
import by.tms.eshop.mapper.OrderIdMapper;
import by.tms.eshop.model.Product;
import by.tms.eshop.repository.JdbcOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcOrderRepositoryImpl implements JdbcOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String CREATE_ORDER = "insert into orders (id, date, user_id) values (?, ?, ?)";
    private static final String SAVE_PRODUCT_IN_ORDER = "insert into order_configurations (order_id, product_id) values (?, ?)";
    private static final String GET_ORDERS_BY_ID = "select o.id, o.date, p.name, p.info, p.price, pt.type from orders o " +
            "join order_configurations oc on o.id = oc.order_id " +
            "join products p on p.id = oc.product_id " +
            "join product_type pt on pt.id = p.product_type_id where user_id=?";
    private static final String GET_ORDERS_NUMBER = "select id from orders where id=?";

    @Override
    public void createOrder(String order, Long id) {
        jdbcTemplate.update(CREATE_ORDER, order, Date.valueOf(LocalDate.now()), id);
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        jdbcTemplate.update(SAVE_PRODUCT_IN_ORDER, order, product.getId());
    }

    @Override
    public List<OrderFullParamDto> getOrdersById(Long id) {
        return jdbcTemplate.query(GET_ORDERS_BY_ID, new OrderFullParamDtoMapper(), id);
    }

    @Override
    public boolean checkOrderNumber(String number) {
        return jdbcTemplate.query(GET_ORDERS_NUMBER, new OrderIdMapper(), number).stream()
                .anyMatch(order -> order.getId().equals(number));
    }
}