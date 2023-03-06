package by.tms.model.warrior;

import by.tms.model.Squad;

public interface Warrior extends Squad {

    @Override
    default String act() {
        return "Warrior cuts with swords";
    }
}