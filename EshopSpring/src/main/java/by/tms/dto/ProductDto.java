package by.tms.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
//@ToString
@Builder
public class ProductDto implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private String info;
}