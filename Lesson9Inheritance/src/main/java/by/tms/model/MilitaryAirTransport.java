package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class MilitaryAirTransport extends AirTransport {
    private boolean ejectionSystems;
    @Setter
    private int numberOfMissilesOnBoard;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Availability of ejection system: " + isEjectionSystems() + "\n" +
                "Number of missiles on board: " + getNumberOfMissilesOnBoard());
    }

    /**
     * The method returns information about a missile shot
     */
    public void returnsStatusOfMissileShot() {
        if (getNumberOfMissilesOnBoard() > 0) {
            shoot();
            System.out.println("The rocket went..");
        } else {
            System.out.println("Ammunition is missing");
        }
    }

    /**
     * The method uses a rocket to fire
     */
    private void shoot() {
        this.setNumberOfMissilesOnBoard(this.getNumberOfMissilesOnBoard() - 1);
    }

    /**
     * The method trying to eject pilot
     */
    public void tryingToEject() {
        if (ejectionSystems) {
            System.out.println("The ejection was successful");
        } else {
            System.out.println("You don't have such a system");
        }
    }
}
