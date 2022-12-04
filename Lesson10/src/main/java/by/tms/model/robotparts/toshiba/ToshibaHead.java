package by.tms.model.robotparts.toshiba;

import by.tms.interfaces.IHead;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ToshibaHead implements IHead {
    @ToString.Exclude
    private int cost;

    @Override
    public String think() {
        return "head with video interface";
    }
}
