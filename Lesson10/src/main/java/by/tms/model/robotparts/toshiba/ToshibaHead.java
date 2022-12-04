package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.IHead;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class ToshibaHead implements IHead {
    private final int cost = 26;

    @Override
    public String think() {
        return "head with video interface";
    }
}
