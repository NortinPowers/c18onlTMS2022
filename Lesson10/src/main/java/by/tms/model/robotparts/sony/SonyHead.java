package by.tms.model.robotparts.sony;

import by.tms.interfaces.IHead;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SonyHead implements IHead {
    @ToString.Exclude
    private int cost;

    @Override
    public String think() {
        return "the head learns to pronounce \"Tokyo Tsushin Kogyo\"";
    }
}
