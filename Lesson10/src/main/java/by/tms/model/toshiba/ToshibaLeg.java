package by.tms.model.toshiba;

import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class ToshibaLeg implements ILeg {
    private final int cost = 16;

    @Override
    public void go() {
        System.out.println("the leg uses a wheel and a gyroscope");
    }
}
