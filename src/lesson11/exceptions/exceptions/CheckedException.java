package lesson11.exceptions.exceptions;

public class CheckedException extends Exception{
    public CheckedException() {
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
