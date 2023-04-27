package by.tms.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@Scope("session")
public class ProductDto implements Serializable {

    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
    private String info;
}