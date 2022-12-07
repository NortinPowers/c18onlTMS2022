package by.tms.model;

import by.tms.interfaces.ClothingForMenAware;
import by.tms.interfaces.ClothingForWomenAware;
import by.tms.model.clothes.Clothes;
import org.jetbrains.annotations.NotNull;

public class Atelier {

    public StringBuilder dressMan(Clothes @NotNull [] clothes) {
        StringBuilder result = new StringBuilder();
        for (Clothes clothesType : clothes) {
            if (clothesType instanceof ClothingForMenAware) {
                getSelectedTypeOfClothingCharacteristics(result, clothesType);
            }
        }
        return new StringBuilder("Men`s clothing:\n" + result);
    }

    public StringBuilder dressWoman(Clothes @NotNull [] clothes) {
        StringBuilder result = new StringBuilder();
        for (Clothes clothesType : clothes) {
            if (clothesType instanceof ClothingForWomenAware) {
                getSelectedTypeOfClothingCharacteristics(result, clothesType);
            }
        }
        return new StringBuilder("Women`s clothing:\n" + result);
    }

    private static void getSelectedTypeOfClothingCharacteristics(@NotNull StringBuilder result, @NotNull Clothes clothesType) {
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
