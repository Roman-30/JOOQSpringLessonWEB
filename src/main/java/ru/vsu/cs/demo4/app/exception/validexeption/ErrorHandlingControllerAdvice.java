package ru.vsu.cs.demo4.app.exception.validexeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vsu.cs.demo4.app.exception.EntityNotFountException;
import ru.vsu.cs.demo4.app.exception.EntityNotSavedException;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFountException.class)
    public ResponseEntity<String> handleCustomException2(EntityNotFountException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotSavedException.class)
    public ResponseEntity<String> handleCustomException1(EntityNotSavedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}