package by.tms.mapper;

import by.tms.dto.OrderFullParamDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static by.tms.utils.RepositoryJdbcUtils.getProductSimpleBuild;

public class OrderFullParamDtoMapper implements RowMapper<OrderFullParamDto> {

    @Override
    public OrderFullParamDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OrderFullParamDto.builder()
                .id(rs.getString("id"))
                .date(LocalDate.parse(rs.getString("date")))
                .productDto(getProductSimpleBuild(rs))
                .build();
    }
}