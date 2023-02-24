package by.tms.model.clothes;

import by.tms.interfaces.IShoes;

public class PumaShoes implements IShoes {

    @Override
    public String putOn() {
        return "put on puma shoes";
    }

    @Override
    public String takeOff() {
        return "take off puma shoes";
    }
}
