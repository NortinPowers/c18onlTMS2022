package by.tms.model.archer;

public interface Archer {

    default String act() {
        return "Archer shoots a bow";
    }
}