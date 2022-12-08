package by.tms.model.robotparts.samsung;

import by.tms.interfaces.IHand;
import by.tms.model.robotparts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class SamsungHand extends RobotParts implements IHand {
    @Override
    public String grab() {
        return "the hand snatches the geom";
    }

}
