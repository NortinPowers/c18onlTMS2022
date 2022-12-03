package by.tms.interfaces;

public interface Describable {
    default void getInfo() {
        System.out.println("It`s " + getClass().getSimpleName());
    }
}
