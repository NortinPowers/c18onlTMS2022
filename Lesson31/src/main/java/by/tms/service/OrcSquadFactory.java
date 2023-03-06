package by.tms.service;

import by.tms.model.archer.Archer;
import by.tms.model.archer.OrcArcher;
import by.tms.model.mage.Mage;
import by.tms.model.mage.OrcMage;
import by.tms.model.warrior.OrcWarrior;
import by.tms.model.warrior.Warrior;

public class OrcSquadFactory implements SquadAbstractFactory {

    @Override
    public Mage createMage() {
        return new OrcMage();
    }

    @Override
    public Warrior createWarrior() {
        return new OrcWarrior();
    }

    @Override
    public Archer createArcher() {
        return new OrcArcher();
    }
}