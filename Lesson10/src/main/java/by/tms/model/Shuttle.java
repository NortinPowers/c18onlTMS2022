package by.tms.model;

import by.tms.interfaces.IStart;

import java.util.Random;

public class Shuttle implements IStart {
    @Override
    public boolean preLaunchSystemCheck() {
        return new Random().nextInt() * 11 > 3;
    }

    @Override
    public String engineStart() {
        return "The Shuttle engines are running. All systems are normal.";
    }

    @Override
    public String start() {
        return "Shuttle Launch";
    }
}
