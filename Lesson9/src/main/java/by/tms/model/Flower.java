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
    private static int floverCount;
    private String name;
    private int price;

    {
        floverCount += 1;
    }

    public static int getFloverCount() {
        return floverCount;
    }
}
