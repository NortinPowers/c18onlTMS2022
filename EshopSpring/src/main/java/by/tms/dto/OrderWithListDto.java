package by.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Scope("session")
public class OrderWithListDto {

    private String order;
    private LocalDate date;
    private List<ProductDto> productsDto;
}