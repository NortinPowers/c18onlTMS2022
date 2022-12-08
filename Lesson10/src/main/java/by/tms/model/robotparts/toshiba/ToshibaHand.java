package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.IHand;
import by.tms.model.robotparts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class ToshibaHand extends RobotParts implements IHand {
    @Override
    public String grab() {
        return "the hand snatches the katana";
    }
}
