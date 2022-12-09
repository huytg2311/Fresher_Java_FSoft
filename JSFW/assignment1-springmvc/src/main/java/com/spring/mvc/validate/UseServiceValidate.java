package com.spring.mvc.validate;

import com.spring.mvc.model.UseService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class UseServiceValidate implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UseService useService = (UseService) target;
        LocalDate localDate = LocalDate.now();
        if (useService.getUseDate().isAfter(localDate)) {
            errors.rejectValue("useDate", "useDate", new String[]{}, "Date over date now!");
        }
    }
}
