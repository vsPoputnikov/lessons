package lesson11.exceptions.exceptions;

public class UncheckedException extends RuntimeException{
    public UncheckedException() {
    }

    public UncheckedException(String message) {
        super(message);
    }

    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
