package by.tms.eshop.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String info;
}