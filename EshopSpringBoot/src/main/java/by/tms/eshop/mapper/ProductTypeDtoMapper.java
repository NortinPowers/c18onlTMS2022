package by.tms.eshop.mapper;

import by.tms.eshop.dto.ProductDto;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTypeDtoMapper implements RowMapper<ProductDto> {

    @Override
    public ProductDto mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return ProductDto.builder()
                .type(rs.getString("type"))
                .build();
    }
}