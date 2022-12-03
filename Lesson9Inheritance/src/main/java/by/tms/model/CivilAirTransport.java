package by.tms.model;

import lombok.Getter;

@Getter
public class CivilAirTransport extends AirTransport {
    private int numberOfPassengers;
    private boolean businessClass;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Number of passengers: " + getNumberOfPassengers() + "\n" +
                "Business class availability: " + isBusinessClass());
    }
}
