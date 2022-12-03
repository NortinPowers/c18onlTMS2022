package by.tms.model;

import by.tms.interfaces.IHand;
import by.tms.interfaces.IHead;
import by.tms.interfaces.ILeg;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString
public class Robot {
    private IHead head;
    private ILeg leg;
    private IHand hand;

    public String action() {
        return head.think() + "\n" + hand.grab() + "\n" + leg.go();
    }

}
