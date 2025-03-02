package ru.vsu.cs.demo4.app.exception;

public class EntityNotFountException extends Exception {
    public EntityNotFountException() {
        super();
    }

    public EntityNotFountException(String message) {
        super(message);
    }

    public EntityNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFountException(Throwable cause) {
        super(cause);
    }

    public EntityNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
