package com.example.schedulerapp.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CronFormatValidatorTest {

    private final CronFormatValidator cronFormatValidator = new CronFormatValidator();

    @Test
    public void testValid1() {
        assertTrue(cronFormatValidator.isValid("0 4 * * * *", null));
    }

    @Test
    public void testValid2() {
        String script = "00 09-18 */2 * 1-5 mon";
        assertTrue(cronFormatValidator.isValid(script, null));
    }

    @Test
    public void testInvalid1() {
        assertFalse(cronFormatValidator.isValid("0 4a * * * *", null));
    }

    @Test
    public void testInvalid2() {
        String script = "* * * * * * *";
        assertFalse(cronFormatValidator.isValid(script, null));
    }

}