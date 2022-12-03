package by.tms.model.samsung;

import by.tms.interfaces.IHead;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SamsungHead implements IHead {
    private final int cost = 25;

    @Override
    public void think() {
        System.out.println("the head thinks of three stars");
    }

}
