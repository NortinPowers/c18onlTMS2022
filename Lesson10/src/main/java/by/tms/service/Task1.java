package by.tms.service;

import by.tms.model.Robot;
import by.tms.model.robot_parts.samsung.SamsungHand;
import by.tms.model.robot_parts.samsung.SamsungHead;
import by.tms.model.robot_parts.samsung.SamsungLeg;
import by.tms.model.robot_parts.sony.SonyHand;
import by.tms.model.robot_parts.sony.SonyHead;
import by.tms.model.robot_parts.sony.SonyLeg;
import by.tms.model.robot_parts.toshiba.ToshibaHand;
import by.tms.model.robot_parts.toshiba.ToshibaHead;
import by.tms.model.robot_parts.toshiba.ToshibaLeg;

import java.util.ArrayList;

import static by.tms.utils.CostDeterminant.getMaxCostOfRobot;


public class Task1 {
    public static void main(String[] args) {
        Robot firstRobot = Robot.builder()
                .hand(SamsungHand.builder().price(20).build())
                .head(ToshibaHead.builder().price(60).build())
                .leg(SamsungLeg.builder().price(30).build())
                .build();
        Robot secondRobot = Robot.builder()
                .hand(SonyHand.builder().price(15).build())
                .head(SonyHead.builder().price(20).build())
                .leg(ToshibaLeg.builder().price(19).build())
                .build();
        Robot thirdRobot = Robot.builder()
                .hand(ToshibaHand.builder().price(18).build())
                .head(SamsungHead.builder().price(16).build())
                .leg(SonyLeg.builder().price(17).build())
                .build();
        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(firstRobot);
        robots.add(secondRobot);
        robots.add(thirdRobot);
        ArrayList<Integer> robotCosts = new ArrayList<>();
        for (int i = 0; i < robots.size(); i++) {
            Robot tempRobot = robots.get(i);
            System.out.println(tempRobot.action());
            robotCosts.add(tempRobot.getHead().getPrice() + tempRobot.getHand().getPrice() + tempRobot.getLeg().getPrice());
            System.out.println("the cost of this robot " + robotCosts.get(i));
            System.out.println();
        }
        int indexOfMaxCost = getMaxCostOfRobot(robotCosts);
        if (indexOfMaxCost > -1) {
            System.out.println("Robot with max cost (" + robotCosts.get(indexOfMaxCost) + ") is " + robots.get(indexOfMaxCost));
        }
    }
}