package by.tms.model.instrument;

import by.tms.service.interfaces.InstrumentAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Drum implements InstrumentAware {

    private int size;

    @Override
    public String play() {
        return "a drum with a diameter of " + size + " is playing now";
    }
}
