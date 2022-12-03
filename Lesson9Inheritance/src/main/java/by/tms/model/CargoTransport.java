package by.tms.model;

import lombok.Getter;

@Getter
public class CargoTransport extends GroundTransportation {
    private int loadCapacity;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Load capacity(t): " + getLoadCapacity());
    }
}
