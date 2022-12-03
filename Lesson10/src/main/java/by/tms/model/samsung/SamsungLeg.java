package by.tms.model.samsung;

import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SamsungLeg implements ILeg {
    private final int cost = 20;

    @Override
    public void go() {
        System.out.println("the leg moves confidently");
    }
}
