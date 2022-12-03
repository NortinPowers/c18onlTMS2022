package by.tms.model;

import lombok.Getter;

@Getter
public class AirTransport extends Transport {
    private int wingspan;
    private int MinimumRunwayLengthForTakeOff;

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Wingspan (m): " + getWingspan() + "\n" +
                "The minimum length of the runway for take-off: " + getMinimumRunwayLengthForTakeOff());
    }
}
