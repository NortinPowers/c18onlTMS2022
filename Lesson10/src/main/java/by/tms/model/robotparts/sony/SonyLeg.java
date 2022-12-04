package by.tms.model.robotparts.sony;

import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SonyLeg implements ILeg {
    private final int cost = 22;

    @Override
    public String go() {
        return "the leg moves cinematically";
    }
}
