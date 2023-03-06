package by.tms.service;

import static by.tms.service.ApplicationsConfiguration.Race.ORC;

import by.tms.model.Squad;
import by.tms.model.archer.Archer;
import by.tms.model.mage.Mage;
import by.tms.model.warrior.Warrior;
import java.util.ArrayList;
import java.util.List;

public class SquadFactoryApplications {

    public static void main(String[] args) {
        ApplicationsConfiguration applicationsConfiguration = new ApplicationsConfiguration();
        SquadAbstractFactory squadAbstractFactory = applicationsConfiguration.setupFactory(ORC);
        List<Squad> squads = new ArrayList<>();
        Warrior warrior = squadAbstractFactory.createWarrior();
        squads.add(warrior);
        Archer archer = squadAbstractFactory.createArcher();
        squads.add(archer);
        Mage mage = squadAbstractFactory.createMage();
        squads.add(mage);
        squads.forEach(squad -> System.out.println(squad.act()));
    }
}