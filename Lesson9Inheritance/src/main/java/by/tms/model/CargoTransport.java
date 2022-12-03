package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CargoTransport extends GroundTransportation {
    private int loadCapacity;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Load capacity(t): " + getLoadCapacity());
    }

    @Override
    public void givesInfoAboutPossibilityOfTransportation(int transported) {
        if (transported <= loadCapacity) {
            System.out.println("The truck is loaded. This amount of cargo (" + transported + "t) can be transported");
        } else {
            System.out.println("You need a bigger truck");
        }
    }
}
