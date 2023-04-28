package by.tms.eshop.mapper;

import by.tms.eshop.dto.ProductDto;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.tms.eshop.utils.RepositoryJdbcUtils.getProductDto;

public class ProductDtoMapper implements RowMapper<ProductDto> {

    @Override
    public ProductDto mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return getProductDto(rs);
    }
}