package by.tms.model.mage;

import by.tms.model.Squad;

public interface Mage extends Squad {

    @Override
    default String act() {
        return "Mage conjures";
    }
}