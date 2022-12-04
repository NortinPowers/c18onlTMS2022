package by.tms.model.robotparts.samsung;

import by.tms.interfaces.ILeg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SamsungLeg implements ILeg {
    @ToString.Exclude
    private int cost;

    @Override
    public String go() {
        return "the leg moves confidently";
    }
}
