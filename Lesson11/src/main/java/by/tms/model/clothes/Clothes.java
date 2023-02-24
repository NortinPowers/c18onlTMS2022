package by.tms.model.clothes;

import by.tms.model.ClothingSize;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Clothes {

    private ClothingSize clothingSize;
    private BigDecimal price;
    private String clothingColor;
}
