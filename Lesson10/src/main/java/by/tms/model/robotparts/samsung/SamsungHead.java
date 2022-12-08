package by.tms.model.robotparts.samsung;

import by.tms.interfaces.IHead;
import by.tms.model.robotparts.RobotParts;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class SamsungHead extends RobotParts implements IHead {
    @Override
    public String think() {
        return "the head thinks of three stars";
    }
}
