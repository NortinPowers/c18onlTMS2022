package by.tms.mapper;

import by.tms.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getString("id"))
//                .date(LocalDate.parse(rs.getString("date")))
//                .userId(rs.getLong("userId"))
                .build();
    }
}
