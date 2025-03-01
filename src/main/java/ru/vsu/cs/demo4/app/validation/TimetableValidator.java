package ru.vsu.cs.demo4.app.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vsu.cs.demo4.app.dto.TimetableBaseDto;

public class TimetableValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TimetableBaseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
