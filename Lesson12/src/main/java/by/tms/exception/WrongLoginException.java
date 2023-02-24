package by.tms.exception;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
