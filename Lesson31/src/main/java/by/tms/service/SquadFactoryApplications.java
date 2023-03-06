package by.tms.service;

import static by.tms.service.ApplicationsConfiguration.Race.ORC;

import by.tms.model.archer.Archer;
import by.tms.model.mage.Mage;
import by.tms.model.warrior.Warrior;

public class SquadFactoryApplications {

    public static void main(String[] args) {
        ApplicationsConfiguration applicationsConfiguration = new ApplicationsConfiguration();
        SquadAbstractFactory squadAbstractFactory = applicationsConfiguration.setupFactory(ORC);
        Warrior warrior = squadAbstractFactory.createWarrior();
        System.out.println(warrior.act());
        Archer archer = squadAbstractFactory.createArcher();
        System.out.println(archer.act());
        Mage mage = squadAbstractFactory.createMage();
        System.out.println(mage.act());
    }
}