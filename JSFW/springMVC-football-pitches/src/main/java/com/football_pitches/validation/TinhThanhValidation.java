package com.football_pitches.validation;

import com.football_pitches.model.TinhThanh;
import com.football_pitches.service.impl.TinhThanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/*
 * Account: HuyTG8
 * Birthday: 2001/11/23
 * */
@Component
public class TinhThanhValidation implements Validator {

    @Autowired
    private TinhThanhService tinhThanhService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        TinhThanh tinhThanh = (TinhThanh) target;

        if (tinhThanhService.existsByMaTT(tinhThanh.getMaTT())) {
            errors.rejectValue("maTT", "maTT", new String[]{}, "MaTT Duplicate!");

        }
    }
}
