package by.tms.model;

import by.tms.interfaces.IJacket;
import by.tms.interfaces.IPants;
import by.tms.interfaces.IShoes;
import lombok.Builder;

@Builder
public class People {
    private String name;
    private IJacket jacket;
    private IPants pants;
    private IShoes shoes;

    public String undressing() {
        return "people " + name + " " + jacket.takeOff() + ", " + shoes.takeOff() + " and " + pants.takeOff() + ".";
    }

    public String dressingUp() {
        return "people " + name + " " + jacket.putOn() + ", " + pants.putOn() + " and " + shoes.putOn() + ".";
    }
}
