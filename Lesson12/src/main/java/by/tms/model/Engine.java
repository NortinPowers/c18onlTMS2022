package by.tms.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Builder(builderMethodName = "internalBuilder")
@Getter
public class Engine {
    @NonNull
    private final String engineType;
    private boolean started;

    public static EngineBuilder builder(String engineType) {
        return internalBuilder().engineType(engineType);
    }

    public void startEngine() {
        started = true;
    }

    public void stopEngine() {
        started = false;
    }
}
