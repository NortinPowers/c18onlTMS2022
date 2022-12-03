package by.tms.model.toshiba;

import by.tms.interfaces.IHand;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class ToshibaHand implements IHand {
    private final int cost = 19;

    @Override
    public void grab() {
        System.out.println("the hand snatches the katana");
    }
}
