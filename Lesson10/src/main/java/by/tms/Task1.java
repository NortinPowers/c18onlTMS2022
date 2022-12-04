package by.tms;

import by.tms.model.Robot;
import by.tms.model.robotparts.samsung.SamsungHand;
import by.tms.model.robotparts.samsung.SamsungHead;
import by.tms.model.robotparts.samsung.SamsungLeg;
import by.tms.model.robotparts.sony.SonyHand;
import by.tms.model.robotparts.sony.SonyHead;
import by.tms.model.robotparts.sony.SonyLeg;
import by.tms.model.robotparts.toshiba.ToshibaHand;
import by.tms.model.robotparts.toshiba.ToshibaHead;
import by.tms.model.robotparts.toshiba.ToshibaLeg;

import java.util.ArrayList;

import static by.tms.utils.CostDeterminant.getMaxCostOfRobot;

public class Task1 {
    public static void main(String[] args) {
        Robot firstRobot = Robot.builder()
                .hand(new SamsungHand(20))
                .head(new ToshibaHead(12))
                .leg(new SamsungLeg(16))
                .build();
        Robot secondRobot = Robot.builder()
                .hand(new SonyHand(15))
                .head(new SonyHead(20))
                .leg(new ToshibaLeg(19))
                .build();
        Robot thirdRobot = Robot.builder()
                .hand(new ToshibaHand(18))
                .head(new SamsungHead(16))
                .leg(new SonyLeg(17))
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
        if (indexOfMaxCost > 0) {
            System.out.println("Robot with max cost (" + robotCosts.get(indexOfMaxCost) + ") is " + robots.get(indexOfMaxCost));
        }
    }
}