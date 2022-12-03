package by.tms.model;

import lombok.Getter;

@Getter
public class MilitaryAirTransport extends AirTransport {
    private boolean ejectionSystems;
    private int NumberOfMissilesOnBoard;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Availability of ejection system: " + isEjectionSystems() + "\n" +
                "Number of missiles on board: " + getNumberOfMissilesOnBoard());
    }
}
