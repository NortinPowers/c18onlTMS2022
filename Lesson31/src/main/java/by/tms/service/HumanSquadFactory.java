package by.tms.service;

import by.tms.model.archer.Archer;
import by.tms.model.archer.HumanArcher;
import by.tms.model.mage.HumanMage;
import by.tms.model.mage.Mage;
import by.tms.model.warrior.HumanWarrior;
import by.tms.model.warrior.Warrior;

public class HumanSquadFactory implements SquadAbstractFactory {

    @Override
    public Mage createMage() {
        return new HumanMage();
    }

    @Override
    public Warrior createWarrior() {
        return new HumanWarrior();
    }

    @Override
    public Archer createArcher() {
        return new HumanArcher();
    }
}