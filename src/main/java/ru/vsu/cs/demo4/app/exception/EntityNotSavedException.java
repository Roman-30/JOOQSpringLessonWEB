package ru.vsu.cs.demo4.app.exception;

public class EntityNotSavedException extends Exception {
    public EntityNotSavedException() {
        super();
    }

    public EntityNotSavedException(String message) {
        super(message);
    }

    public EntityNotSavedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotSavedException(Throwable cause) {
        super(cause);
    }

    protected EntityNotSavedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
