package by.tms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
}