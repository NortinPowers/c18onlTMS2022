package by.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class AirTransport extends Transport {
    private double wingspan;
    private int minimumRunwayLengthForTakeOff;

    @Override
    public String givesInfo() {
        return super.givesInfo() + "\nWingspan (m): " + getWingspan() + "\n" +
                "The minimum length of the runway for take-off: " + getMinimumRunwayLengthForTakeOff();
    }
}
