package by.tms.mapper;

import by.tms.dto.ProductDto;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.tms.utils.RepositoryJdbcUtils.getProductDto;

public class ProductDtoMapper implements RowMapper<by.tms.dto.ProductDto> {

    @Override
    public ProductDto mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        return getProductDto(rs);
    }
}