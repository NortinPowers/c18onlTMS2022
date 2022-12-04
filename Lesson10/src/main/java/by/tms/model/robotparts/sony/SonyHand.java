package by.tms.model.robotparts.sony;

import by.tms.interfaces.IHand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SonyHand implements IHand {
    @ToString.Exclude
    private int cost;

    @Override
    public String grab() {
        return "the hand holds the camera";
    }
}
