//package by.tms.mapper;
//
//import by.tms.model.Cart;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CartMapper implements RowMapper<Cart> {
//    @Override
//    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return Cart.builder()
//                .userId(rs.getLong("userid"))
//                .productId(rs.getLong("productId"))
////                .count(rs.getInt("count"))
//                .build();
//    }
//}
