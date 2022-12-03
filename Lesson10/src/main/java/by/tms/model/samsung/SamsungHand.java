package by.tms.model.samsung;

import by.tms.interfaces.IHand;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SamsungHand implements IHand {
    private final int cost = 20;

    @Override
    public String grab() {
        return "the hand snatches the geom";
    }
}
