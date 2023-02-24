package by.tms.model.robot_parts.samsung;

import by.tms.interfaces.ILeg;
import by.tms.model.robot_parts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class SamsungLeg extends RobotParts implements ILeg {

    @Override
    public String go() {
        return "the leg moves confidently";
    }
}
