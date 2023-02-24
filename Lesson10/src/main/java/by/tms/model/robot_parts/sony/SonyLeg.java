package by.tms.model.robot_parts.sony;

import by.tms.interfaces.ILeg;
import by.tms.model.robot_parts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class SonyLeg extends RobotParts implements ILeg {

    @Override
    public String go() {
        return "the leg moves cinematically";
    }
}
