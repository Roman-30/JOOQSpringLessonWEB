package ru.vsu.cs.demo4.app.exception.validexeption.record;

import java.util.List;


public record ValidationErrorResponse(List<Violation> violations) {

}