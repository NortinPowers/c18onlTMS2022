package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CivilAirTransport extends AirTransport {
    private int numberOfPassengers;
    private boolean businessClass;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Number of passengers: " + getNumberOfPassengers() + "\n" +
                "Business class availability: " + isBusinessClass());
    }

    @Override
    public void givesInfoAboutPossibilityOfTransportation(int transported) {
        if (transported <= numberOfPassengers) {
            System.out.println(transported + " passengers can be transported");
        } else {
            System.out.println("You need a bigger aircraft");
        }
    }
}
