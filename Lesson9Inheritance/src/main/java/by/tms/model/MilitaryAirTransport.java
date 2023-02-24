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
    public String givesInfo() {
        return super.givesInfo() + "\nAvailability of ejection system: " + isEjectionSystems() + "\n" +
                "Number of missiles on board: " + getNumberOfMissilesOnBoard();
    }

    /**
     * The method returns information about a missile shot
     */
    public String returnsStatusOfMissileShot() {
        if (getNumberOfMissilesOnBoard() > 0) {
            shoot();
            return "The rocket went..";
        } else {
            return "Ammunition is missing";
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
    public String tryingToEject() {
        if (ejectionSystems) {
            return "The ejection was successful";
        } else {
            return "You don't have such a system";
        }
    }
}
