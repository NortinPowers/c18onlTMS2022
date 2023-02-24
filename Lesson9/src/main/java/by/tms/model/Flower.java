package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Flower {

    private static int flowerCount;
    private String name;
    private int price;

    {
        flowerCount += 1;
    }

    public static int getFlowerCount() {
        return flowerCount;
    }
}
