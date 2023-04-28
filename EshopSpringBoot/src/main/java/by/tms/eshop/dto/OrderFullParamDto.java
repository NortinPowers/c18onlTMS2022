package by.tms.eshop.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class OrderFullParamDto {

    private String id;
    private LocalDate date;
    private Long userId;
    private ProductDto productDto;
    private Integer productsCount;
}