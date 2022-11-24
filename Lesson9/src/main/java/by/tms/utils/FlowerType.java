package by.tms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlowerType {
    ROSE(15, "Rose"),
    LILY(7, "Lily"),
    ASTER(5, "Aster"),
    GERBERA(5, "Gerbera"),
    TULIP(8, "Tulip"),
    CARNATION(11, "Carnation"),
    PEONY(6, "Peony"),
    IRIS(9, "Iris"),
    DAISY(2, "Daisy");

    private final int cost;
    private final String name;
}
