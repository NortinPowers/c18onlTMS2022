package by.tms.model;

import lombok.Getter;

@Getter
public class PassengerTransport extends GroundTransportation {
    private String bodyType;
    private int numberOfPassengers;

    @Override
    public void getInfo() {
        System.out.println("Body type: " + getBodyType() + "\n" +
                "Number of passengers: " + getNumberOfPassengers());
    }

    /**
     * The method provides information about the distance traveled for a certain time and about the fuel spent on this path
     */
    public void givesInfoAboutTripCertainDuration(int travelTime) {
        double distanceTraveled = getMaxSpeedKmPerHour() * travelTime;
        double fuelUsedUp = getFuelUsedUp(distanceTraveled);
        System.out.println("When driving at maximum speed for " + travelTime + " hours,\n" +
                "the " + getBrand() + "brand car moving at maximum speed " + getMaxSpeedKmPerHour() + "(km/h) will travel\n" +
                "" + distanceTraveled + " kilometers, " + fuelUsedUp + " liters of fuel will be consumed");
    }

    /**
     * The method returns fuel consumption depending on the distance traveled
     */
    private double getFuelUsedUp(double distanceTraveled) {
        return (getFuelConsumption() * distanceTraveled) / 100;
    }
}
