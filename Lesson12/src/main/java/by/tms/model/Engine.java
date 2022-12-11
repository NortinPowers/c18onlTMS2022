package by.tms.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Engine {
    private final String engineType;
    private boolean started;

    private Engine(EngineBuilder engineBuilder) {
        engineType = engineBuilder.engineType;
    }

    public static class EngineBuilder {
        private final String engineType;

        public EngineBuilder(String engineType) {
            this.engineType = engineType;
        }

        public Engine build() {
            return new Engine(this);
        }
    }

    public void startEngine() {
        started = true;
    }

    public void stopEngine() {
        started = false;
    }
}
