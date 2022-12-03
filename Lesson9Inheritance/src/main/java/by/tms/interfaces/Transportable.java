package by.tms.interfaces;

public interface Transportable {
    /**
     * The method provide information about the possibility of transporting a certain cargo
     */
    default void givesInfoAboutPossibilityOfTransportation(int transported) {
        System.out.println("The possibility of transportation is not checked");
    }
}
