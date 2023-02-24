package by.tms.interfaces;

public interface Describable {

    /**
     * The method gives information about the object
     */
    default String givesInfo() {
        return "It`s " + getClass().getSimpleName();
    }
}
