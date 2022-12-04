package by.tms.model.robotparts.samsung;

import by.tms.interfaces.IHead;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SamsungHead implements IHead {
    @ToString.Exclude
    private int cost;

    @Override
    public String think() {
        return "the head thinks of three stars";
    }

}
