package by.tms.utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class CostDeterminant {

    public int getMaxCostOfRobot(ArrayList<Integer> robotCosts) {
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
