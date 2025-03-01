package ru.vsu.cs.demo4.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vsu.cs.demo4.app.dto.LecturerBaseDto;

@Component
public class LecturerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LecturerBaseDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
