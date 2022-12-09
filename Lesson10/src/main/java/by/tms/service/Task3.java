package by.tms.service;

import by.tms.interfaces.IStart;
import by.tms.model.Spaceport;
import by.tms.model.shuttle.Shuttle;
import by.tms.model.shuttle.SpaceX;
import by.tms.model.shuttle.Virgin;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        Spaceport spaceport = new Spaceport();
        List<IStart> shuttles = List.of(new Shuttle(), new SpaceX(), new Virgin());
        for (IStart shuttle : shuttles) {
            System.out.println(spaceport.launch(shuttle));
            System.out.println();
        }
    }
}
