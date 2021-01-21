package com.example.schedulerapp.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroovyScriptValidatorTest {
    private final GroovyScriptValidator groovyScriptValidator = new GroovyScriptValidator();

    @Test
    public void testValid1() {
        assertTrue(groovyScriptValidator.isValid("println \"test\"", null));
    }

    @Test
    public void testValid2() {
        String script = "int fib(int n) { n < 2 ? 1 : fib(n-1) + fib(n-2)} \r\nprintln fib(10)";
        assertTrue(groovyScriptValidator.isValid(script, null));
    }

    @Test
    public void testInvalid1() {
        assertFalse(groovyScriptValidator.isValid("println test\"", null));
    }

    @Test
    public void testInvalid2() {
        String script = "int fib(int n) { n < 2 ? 1 : fib(n-1) + fib(n-2)} println fib(10)";
        assertFalse(groovyScriptValidator.isValid(script, null));
    }
}