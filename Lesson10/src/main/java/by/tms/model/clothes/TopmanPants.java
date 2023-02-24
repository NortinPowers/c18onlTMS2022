package by.tms.model.clothes;

import by.tms.interfaces.IPants;

public class TopmanPants implements IPants {

    @Override
    public String putOn() {
        return "put on topman pants";
    }

    @Override
    public String takeOff() {
        return "take off topman pants";
    }
}
