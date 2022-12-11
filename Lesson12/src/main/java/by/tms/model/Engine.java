package by.tms.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Engine {
    private final String engineType;
    private boolean started;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public void startEngine() {
        started = true;
    }

    public void stopEngine() {
        started = false;
    }
}
