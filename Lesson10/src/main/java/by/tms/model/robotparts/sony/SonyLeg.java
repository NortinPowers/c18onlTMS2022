package by.tms.model.robotparts.sony;

import by.tms.interfaces.ILeg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SonyLeg implements ILeg {
    @ToString.Exclude
    private int cost;

    @Override
    public String go() {
        return "the leg moves cinematically";
    }
}
