package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.IHand;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class ToshibaHand implements IHand {
    private final int cost = 19;

    @Override
    public String grab() {
        return "the hand snatches the katana";
    }
}
