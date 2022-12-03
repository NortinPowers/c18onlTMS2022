package by.tms.model.sony;

import by.tms.interfaces.IHand;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SonyHand implements IHand {
    private final int cost = 18;

    @Override
    public void grab() {
        System.out.println("the hand holds the camera");
    }
}
