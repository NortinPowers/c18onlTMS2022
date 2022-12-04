package by.tms.model;

import by.tms.interfaces.IStart;

public class Spaceport {

    public String launch(IStart begin) {
        if (begin.preLaunchSystemCheck()) {
            return begin.engineStart() + "\n" + getCountdown() + begin.start();
        } else {
            return "Pre-launch check failed.";
        }
    }

    private static StringBuilder getCountdown() {
        StringBuilder countdown = new StringBuilder();
        for (int i = 10; i >= 0; i--) {
            countdown.append(i).append("\n");
        }
        return countdown;
    }
}
