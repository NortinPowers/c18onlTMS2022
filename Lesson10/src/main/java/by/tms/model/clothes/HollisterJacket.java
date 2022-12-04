package by.tms.model.clothes;

import by.tms.interfaces.IJacket;

public class HollisterJacket implements IJacket {
    @Override
    public String putOn() {
        return "put on hollister jacket";
    }

    @Override
    public String takeOff() {
        return "take off hollister jacket";
    }
}
