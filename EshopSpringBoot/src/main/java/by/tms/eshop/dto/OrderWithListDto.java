package by.tms.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderWithListDto {

    private String order;
    private LocalDate date;
    private List<ProductDto> productsDto;
}