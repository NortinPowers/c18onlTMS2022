package by.tms.model.robotparts.sony;

import by.tms.interfaces.IHand;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SonyHand implements IHand {
    private final int cost = 18;

    @Override
    public String grab() {
        return "the hand holds the camera";
    }
}
