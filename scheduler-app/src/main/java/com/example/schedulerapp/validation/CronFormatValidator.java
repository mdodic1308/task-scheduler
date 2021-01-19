package com.example.schedulerapp.validation;

import org.springframework.scheduling.support.CronExpression;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CronFormatValidator implements ConstraintValidator<CronFormatValidation, String> {

    @Override
    public void initialize(CronFormatValidation reccurency) {
    }

    @Override
    public boolean isValid(String reccurency,
            ConstraintValidatorContext cxt) {
        try {
            CronExpression.parse(reccurency);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}