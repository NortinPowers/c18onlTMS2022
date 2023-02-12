package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@EqualsAndHashCode

@ToString

public class Product implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType type;
    private String info;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}