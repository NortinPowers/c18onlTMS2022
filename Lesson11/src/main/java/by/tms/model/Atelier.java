package by.tms.model;

import by.tms.model.clothes.Clothes;
import by.tms.service.interfaces.ClothingForMenAware;
import by.tms.service.interfaces.ClothingForWomenAware;
import org.jetbrains.annotations.NotNull;

import static by.tms.utils.Typer.getSelectedTypeOfClothingCharacteristics;

public class Atelier {

    public StringBuilder dressMan(@NotNull Clothes[] clothes) {
        StringBuilder result = new StringBuilder();
        for (Clothes clothesType : clothes) {
            if (clothesType instanceof ClothingForMenAware) {
                getSelectedTypeOfClothingCharacteristics(result, clothesType);
            }
        }
        return new StringBuilder("Men`s clothing:\n" + result);
    }

    public StringBuilder dressWoman(@NotNull Clothes[] clothes) {
        StringBuilder result = new StringBuilder();
        for (Clothes clothesType : clothes) {
            if (clothesType instanceof ClothingForWomenAware) {
                getSelectedTypeOfClothingCharacteristics(result, clothesType);
            }
        }
        return new StringBuilder("Women`s clothing:\n" + result);
    }
}
