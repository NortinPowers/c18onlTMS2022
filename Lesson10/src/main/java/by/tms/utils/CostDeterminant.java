package by.tms.utils;

import java.util.ArrayList;

public final class CostDeterminant {

    private CostDeterminant() {
    }

    public static int getMaxCostOfRobot(ArrayList<Integer> robotCosts) {
        int maxCost;
        int index = -1;
        if (robotCosts.size() > 0) {
            maxCost = robotCosts.get(0);
            index = 0;
            for (int i = 1; i < robotCosts.size(); i++) {
                if (maxCost < robotCosts.get(i)) {
                    maxCost = robotCosts.get(i);
                    index = robotCosts.indexOf(maxCost);
                }
            }
            return index;
        }
        return index;
    }
}
