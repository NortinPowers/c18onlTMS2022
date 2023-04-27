package by.tms.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Builder
@Getter
@Scope("session")
public class OrderFullParamDto {

    private String id;
    private LocalDate date;
    private Long userId;
    private ProductDto productDto;
    private Integer productsCount;
}