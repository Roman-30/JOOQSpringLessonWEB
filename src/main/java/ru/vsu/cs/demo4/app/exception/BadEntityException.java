package ru.vsu.cs.demo4.app.exception;

public class BadEntityException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public BadEntityException(String message) {
        super(message);
    }
}
