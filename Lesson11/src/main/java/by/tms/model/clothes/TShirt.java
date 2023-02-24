package by.tms.model.clothes;

import by.tms.service.interfaces.ClothingForMenAware;
import by.tms.service.interfaces.ClothingForWomenAware;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class TShirt extends Clothes implements ClothingForMenAware, ClothingForWomenAware {

}
