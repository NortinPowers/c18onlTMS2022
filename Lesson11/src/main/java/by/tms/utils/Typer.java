package by.tms.utils;

import by.tms.model.clothes.Clothes;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class Typer {
    public void getSelectedTypeOfClothingCharacteristics(@NotNull StringBuilder result, @NotNull Clothes clothesType) {
        result.append(clothesType.getClass().getSimpleName())
                .append(": Clothing size - ")
                .append(clothesType.getClothingSize())
                .append(", clothing color - ")
                .append(clothesType.getClothingColor())
                .append(", price - ")
                .append(clothesType.getPrice())
                .append("\n");
    }
}
