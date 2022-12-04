package by.tms.interfaces;

public interface Transportable {
    /**
     * The method provide information about the possibility of transporting a certain cargo
     */
    default String givesInfoAboutPossibilityOfTransportation(int transported) {
        return "The possibility of transportation is not checked";
    }
}
