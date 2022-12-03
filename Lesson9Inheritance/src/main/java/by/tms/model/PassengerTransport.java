package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PassengerTransport extends GroundTransportation {
    private String bodyType;
    private int numberOfPassengers;

    @Override
    public String givesInfo() {
        return "Body type: " + getBodyType() + "\n" +
                "Number of passengers: " + getNumberOfPassengers();
    }

    /**
     * The method provides information about the distance traveled for a certain time and about the fuel spent on this path
     */
    public String givesInfoAboutTripCertainDuration(int travelTime) {
        double distanceTraveled = getMaxSpeedKmPerHour() * travelTime;
        double fuelUsedUp = getFuelUsedUp(distanceTraveled);
        return "When driving at maximum speed for " + travelTime + " hours,\n" +
                "the " + getBrand() + " brand car moving at maximum speed " + getMaxSpeedKmPerHour() + "(km/h) will travel\n" +
                "" + distanceTraveled + " kilometers, " + fuelUsedUp + " liters of fuel will be consumed";
    }

    /**
     * The method returns fuel consumption depending on the distance traveled
     */
    private double getFuelUsedUp(double distanceTraveled) {
        return (getFuelConsumption() * distanceTraveled) / 100;
    }
}
