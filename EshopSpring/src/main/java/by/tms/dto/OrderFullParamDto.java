package by.tms.dto;

import by.tms.model.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class OrderFullParamDto {

    private String id;
    private LocalDate date;
    private Long userId;
    private Product product;
    private Integer productsCount;
}
