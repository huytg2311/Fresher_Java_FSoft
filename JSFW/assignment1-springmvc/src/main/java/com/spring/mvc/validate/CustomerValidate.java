package com.spring.mvc.validate;

import com.spring.mvc.model.Customer;
import com.spring.mvc.model.UseComputer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class CustomerValidate implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UseComputer useComputer =(UseComputer) target;
        LocalDate localDate = LocalDate.now();
        if (useComputer.getUseDate().isAfter(localDate)) {
            errors.rejectValue("useDate", "useDate", new String[]{}, "Date over date now!");
        }

    }
}
