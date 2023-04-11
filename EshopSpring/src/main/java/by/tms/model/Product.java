package by.tms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
//@ToString
@Builder
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String info;
}