package by.tms.model;

public class Engine {

    private final String engineType;
    private boolean started;

    public boolean startEngine() {
        return started = true;
    }

    public boolean stopEngine() {
        return started = false;
    }

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Engine {'" +
                engineType + '\'' +
                '}';
    }
}
