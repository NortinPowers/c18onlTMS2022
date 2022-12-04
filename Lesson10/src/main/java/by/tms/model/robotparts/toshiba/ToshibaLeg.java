package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.ILeg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ToshibaLeg implements ILeg {
    @ToString.Exclude
    private int cost;

    @Override
    public String go() {
        return "the leg uses a wheel and a gyroscope";
    }
}
