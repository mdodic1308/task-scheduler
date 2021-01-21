package com.example.schedulerapp.validation;

import org.springframework.scheduling.support.CronExpression;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CronFormatValidator implements ConstraintValidator<CronFormatValidation, String> {

    @Override
    public void initialize(CronFormatValidation reccurency) {
    }

    @Override
    public boolean isValid(String recurrency,
            ConstraintValidatorContext cxt) {
        try {
            CronExpression.parse(recurrency);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}