package by.tms.service;

import by.tms.model.archer.Archer;
import by.tms.model.mage.Mage;
import by.tms.model.warrior.Warrior;

public interface SquadAbstractFactory {

    Mage createMage();

    Warrior createWarrior();

    Archer createArcher();
}