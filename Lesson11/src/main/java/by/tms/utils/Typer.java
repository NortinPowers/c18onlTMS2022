package by.tms.utils;

import by.tms.model.clothes.Clothes;
import org.jetbrains.annotations.NotNull;

public class Typer {
    public static void getSelectedTypeOfClothingCharacteristics(@NotNull StringBuilder result, @NotNull Clothes clothesType) {
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
