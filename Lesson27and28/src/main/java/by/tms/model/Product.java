package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Product implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String info;
}