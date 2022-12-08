package by.tms.model;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString
@SuperBuilder
@Getter
public class Engine {
    private final String engineType;
    private boolean started;

    public void startEngine() {
        started = true;
    }

    public void stopEngine() {
        started = false;
    }
}
