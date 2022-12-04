package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CargoTransport extends GroundTransportation {
    private int loadCapacity;

    @Override
    public String givesInfo() {
        return super.givesInfo() + "\nLoad capacity(t): " + getLoadCapacity();
    }

    @Override
    public String givesInfoAboutPossibilityOfTransportation(int transported) {
        if (transported <= loadCapacity) {
            return "The truck is loaded. This amount of cargo (" + transported + "t) can be transported";
        } else {
            return "You need a bigger truck";
        }
    }
}
