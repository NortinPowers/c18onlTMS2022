package by.tms.model.clothes;

import by.tms.interfaces.IPants;

public class VersacePants implements IPants {
    @Override
    public String putOn() {
        return "put on versace pants";
    }

    @Override
    public String takeOff() {
        return "take off versace pants";
    }
}
