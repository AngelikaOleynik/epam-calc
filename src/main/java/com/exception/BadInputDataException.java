package main.java.com.exception;

public class BadInputDataException extends Throwable {
    public BadInputDataException() {
    }

    public BadInputDataException(String message) {
        super(message);
    }

    public BadInputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
