package by.tms.model.clothes;

import by.tms.interfaces.ClothingForMenAware;
import by.tms.interfaces.ClothingForWomenAware;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TShirt extends Clothes implements ClothingForMenAware, ClothingForWomenAware {
}
