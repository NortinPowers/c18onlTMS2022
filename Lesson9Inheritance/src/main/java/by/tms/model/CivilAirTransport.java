package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CivilAirTransport extends AirTransport {
    private int numberOfPassengers;
    private boolean businessClass;

    @Override
    public String givesInfo() {
        return super.givesInfo() + "\nNumber of passengers: " + getNumberOfPassengers() + "\n" +
                "Business class availability: " + isBusinessClass();
    }

    @Override
    public String givesInfoAboutPossibilityOfTransportation(int transported) {
        if (transported <= numberOfPassengers) {
            return transported + " passengers can be transported";
        } else {
            return "You need a bigger aircraft";
        }
    }
}
