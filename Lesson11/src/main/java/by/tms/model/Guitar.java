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
public class Guitar implements InstrumentAware {
    private int numberOfStrings;

    @Override
    public String play() {
        return "a " + numberOfStrings + "-string guitar is playing now";
    }
}
