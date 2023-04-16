package by.tms.mapper;

import by.tms.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderIdMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getString("id"))
                .build();
    }
}