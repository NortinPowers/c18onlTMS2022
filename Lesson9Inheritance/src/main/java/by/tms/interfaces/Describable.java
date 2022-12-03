package by.tms.interfaces;

public interface Describable {
    /**
     * The method gives information about the object
     */
    default void getInfo() {
        System.out.println("It`s " + getClass().getSimpleName());
    }
}
