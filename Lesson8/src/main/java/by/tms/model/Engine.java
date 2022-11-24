package by.tms.model;

public class Engine {

    private final String engineType;
    private boolean started;

    public void startEngine() {
        started = true;
    }

    public void stopEngine() {
        started = false;
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
