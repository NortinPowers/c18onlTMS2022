package by.tms.model.clothes;

import by.tms.interfaces.IJacket;

public class BossJacket implements IJacket {

    @Override
    public String putOn() {
        return "put on boss jacket";
    }

    @Override
    public String takeOff() {
        return "take off boss jacket";
    }
}
