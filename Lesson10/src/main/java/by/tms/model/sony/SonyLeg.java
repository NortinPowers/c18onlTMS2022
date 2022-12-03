package by.tms.model.sony;

import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SonyLeg implements ILeg {
    private final int cost = 22;

    @Override
    public void go() {
        System.out.println("the leg moves cinematically");
    }
}
