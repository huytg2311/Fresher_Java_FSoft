package com.spring.mvc.validate;

import com.spring.mvc.model.Computer;
import com.spring.mvc.service.impl.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ComputerValidate implements Validator {

    @Autowired
    private ComputerService computerService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Computer computer = (Computer) target;

        if (computerService.existsByComputerId(computer.getComputerId())) {
            errors.rejectValue("computerId", "computerId", new String[]{}, "ComputerID Duplicate!");
        }
    }
}
