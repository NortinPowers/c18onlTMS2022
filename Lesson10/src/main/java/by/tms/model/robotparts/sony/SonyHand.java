package by.tms.model.robotparts.sony;

import by.tms.interfaces.IHand;
import by.tms.model.robotparts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class SonyHand extends RobotParts implements IHand {
    @Override
    public String grab() {
        return "the hand holds the camera";
    }
}
