package by.tms.service;

import by.tms.model.archer.Archer;
import by.tms.model.archer.ElfArcher;
import by.tms.model.mage.ElfMage;
import by.tms.model.mage.Mage;
import by.tms.model.warrior.ElfWarrior;
import by.tms.model.warrior.Warrior;

public class ElfSquadFactory implements SquadAbstractFactory {

    @Override
    public Mage createMage() {
        return new ElfMage();
    }

    @Override
    public Warrior createWarrior() {
        return new ElfWarrior();
    }

    @Override
    public Archer createArcher() {
        return new ElfArcher();
    }
}