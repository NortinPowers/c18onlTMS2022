package by.tms.model.robot_parts.toshiba;

import by.tms.interfaces.ILeg;
import by.tms.model.robot_parts.RobotParts;
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
