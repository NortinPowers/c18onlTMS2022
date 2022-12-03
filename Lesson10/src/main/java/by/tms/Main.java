package by.tms;

import by.tms.model.Robot;
import by.tms.model.samsung.SamsungHand;
import by.tms.model.samsung.SamsungHead;
import by.tms.model.samsung.SamsungLeg;
import by.tms.model.sony.SonyHand;
import by.tms.model.sony.SonyHead;
import by.tms.model.sony.SonyLeg;
import by.tms.model.toshiba.ToshibaHand;
import by.tms.model.toshiba.ToshibaHead;
import by.tms.model.toshiba.ToshibaLeg;

import java.util.ArrayList;

import static by.tms.utils.CostDeterminant.getMaxCostOfRobot;

public class Main {
    public static void main(String[] args) {
        Robot firstRobot = Robot.builder()
                .hand(new SamsungHand())
                .head(new ToshibaHead())
                .leg(new SamsungLeg())
                .build();
        Robot secondRobot = Robot.builder()
                .hand(new SonyHand())
                .head(new SonyHead())
                .leg(new ToshibaLeg())
                .build();
        Robot thirdRobot = Robot.builder()
                .hand(new ToshibaHand())
                .head(new SamsungHead())
                .leg(new SonyLeg())
                .build();
        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(firstRobot);
        robots.add(secondRobot);
        robots.add(thirdRobot);
        ArrayList<Integer> robotCosts = new ArrayList<>();
        for (int i = 0; i < robots.size(); i++) {
            Robot tempRobot = robots.get(i);
            System.out.println(tempRobot.action());
            robotCosts.add(tempRobot.getHead().getCost() + tempRobot.getHand().getCost() + tempRobot.getLeg().getCost());
            System.out.println("the cost of this robot " + robotCosts.get(i));
            System.out.println();
        }
        int indexOfMaxCost = getMaxCostOfRobot(robotCosts);
        System.out.println("Robot with max cost (" + robotCosts.get(indexOfMaxCost) + ") is " + robots.get(indexOfMaxCost));
    }
}