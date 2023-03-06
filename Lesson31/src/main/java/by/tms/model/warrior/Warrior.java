package by.tms.model.warrior;

public interface Warrior {

    default String act() {
        return "Warrior cuts with swords";
    }
}