package by.tms.model.archer;

import by.tms.model.Squad;

public interface Archer extends Squad {

    @Override
    default String act() {
        return "Archer shoots a bow";
    }
}