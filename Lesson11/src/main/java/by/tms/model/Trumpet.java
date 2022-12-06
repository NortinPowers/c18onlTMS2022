package by.tms.model;

import by.tms.interfaces.InstrumentAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Trumpet implements InstrumentAware {
    private int diameter;

    @Override
    public String play() {
        return "now the trumpet is playing, it is " + diameter + " in diameter";
    }
}
