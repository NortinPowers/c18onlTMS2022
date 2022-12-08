package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.ILeg;
import by.tms.model.robotparts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class ToshibaLeg extends RobotParts implements ILeg {
    @Override
    public String go() {
        return "the leg uses a wheel and a gyroscope";
    }
}
