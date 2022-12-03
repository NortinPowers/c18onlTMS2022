package by.tms.model.samsung;

import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)

public class SamsungLeg implements ILeg {
    private final int cost = 20;

    @Override
    public String go() {
        return "the leg moves confidently";
    }
}
