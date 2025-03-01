package ru.vsu.cs.demo4.app.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vsu.cs.demo4.app.dto.SubjectBaseDto;

public class SubjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SubjectBaseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
