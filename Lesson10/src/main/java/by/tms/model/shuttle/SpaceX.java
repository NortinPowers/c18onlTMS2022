package by.tms.model.shuttle;

import by.tms.interfaces.IStart;

import java.util.Random;

public class SpaceX implements IStart {

    @Override
    public boolean preLaunchSystemCheck() {
        return new Random().nextInt() * 11 % 2 == 0;
    }

    @Override
    public String engineStart() {
        return "The Falcon engines are running. All systems are normal.";
    }

    @Override
    public String start() {
        return "Dragon Launch";
    }
}
