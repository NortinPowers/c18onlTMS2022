package by.tms.model.robot_parts.toshiba;

import by.tms.interfaces.IHead;
import by.tms.model.robot_parts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class ToshibaHead extends RobotParts implements IHead {

    @Override
    public String think() {
        return "head with video interface";
    }
}
