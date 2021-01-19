package com.example.schedulerapp.validation;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilationFailedException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroovyScriptValidator implements ConstraintValidator<GroovyScriptValidation, String> {

    @Override
    public void initialize(GroovyScriptValidation contactNumber) {
    }

    @Override
    public boolean isValid(String code,
            ConstraintValidatorContext cxt) {
        GroovyShell groovyShell = new GroovyShell();
        try {
            groovyShell.parse(code);
            return true;
        } catch (CompilationFailedException e) {
            return false;
        }
    }
}
