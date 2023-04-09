package by.tms.mapper;

import static by.tms.utils.DtoUtils.makeProductModelTransfer;
import static by.tms.utils.RepositoryJdbcUtils.getProduct;

import by.tms.dto.ProductDto;
import by.tms.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.NonNull;
import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<ProductDto> {

    @Override
    public ProductDto mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        Product product = getProduct(rs);
        return makeProductModelTransfer(product);
    }
}
