package by.tms.mapper;

import by.tms.model.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartCountMapper implements RowMapper<Cart> {
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Cart.builder()
                .count(rs.getInt("count"))
                .build();
    }
}