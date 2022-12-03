package by.tms.model.sony;

import by.tms.interfaces.IHead;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(onlyExplicitlyIncluded = true)
public class SonyHead implements IHead {
    private final int cost = 23;

    @Override
    public void think() {
        System.out.println("the head learns to pronounce \"Tokyo Tsushin Kogyo\"");
    }
}
