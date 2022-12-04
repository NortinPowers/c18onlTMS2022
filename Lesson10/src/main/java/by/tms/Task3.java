package by.tms;

import by.tms.model.Spaceport;
import by.tms.model.shuttle.Shuttle;
import by.tms.model.shuttle.SpaceX;
import by.tms.model.shuttle.Virgin;

public class Task3 {
    public static void main(String[] args) {
        Spaceport spaceport = new Spaceport();
        System.out.println(spaceport.launch(new Shuttle()));
        System.out.println();
        System.out.println(spaceport.launch(new SpaceX()));
        System.out.println();
        System.out.println(spaceport.launch(new Virgin()));
    }
}
