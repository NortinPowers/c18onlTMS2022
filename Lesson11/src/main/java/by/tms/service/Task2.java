package by.tms.service;

import by.tms.interfaces.ClothingForMenAware;
import by.tms.interfaces.ClothingForWomenAware;
import by.tms.model.Atelier;
import by.tms.model.clothes.*;

import java.math.BigDecimal;

import static by.tms.utils.ClothingSize.*;

public class Task2 {
    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[4];
        clothes[0] = Pants.builder()
                .clothingSize(XS)
                .price(new BigDecimal("74.26"))
                .clothingColor("black")
                .build();
        clothes[1] = Skirt.builder()
                .clothingSize(XXS)
                .price(new BigDecimal("120.12"))
                .clothingColor("red")
                .build();
        clothes[2] = Tie.builder()
                .clothingSize(L)
                .price(new BigDecimal("90.54"))
                .clothingColor("vinous")
                .build();
        clothes[3] = TShirt.builder()
                .clothingSize(S)
                .price(new BigDecimal("30.655"))
                .clothingColor("blue")
                .build();
        Atelier atelier = new Atelier();
        System.out.println(atelier.dressMan(clothes));
        System.out.println(atelier.dressWoman(clothes));
        System.out.println(((ClothingForMenAware) clothes[3]).dressMan());
        System.out.println(((ClothingForWomenAware) clothes[1]).dressWoman());
        System.out.println(clothes[1].getClothingSize().getDescription());
        System.out.println(clothes[2].getClothingSize().getDescription());

    }
}
