package by.tms.model.clothes;

import by.tms.model.ClothingSize;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public abstract class Clothes {
    private ClothingSize clothingSize;
    private BigDecimal price;
    private String clothingColor;
}
