package by.tms.model.robotparts.samsung;

import by.tms.interfaces.IHand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SamsungHand implements IHand {
    @ToString.Exclude
    private int cost;

    @Override
    public String grab() {
        return "the hand snatches the geom";
    }
}