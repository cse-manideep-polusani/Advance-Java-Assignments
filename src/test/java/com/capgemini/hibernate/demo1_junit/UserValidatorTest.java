package com.capgemini.hibernate.demo1_junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserValidatorTest {

    @Test
    void testValidUsername() {
        assertTrue(UserValidator.isValidUsername("john123"), "Valid username should return true");
    }

    @Test
    void testInvalidUsernameWithSpecialCharacters() {
        assertFalse(UserValidator.isValidUsername("john@123"), "Username with special characters should return false");
    }

    @Test
    void testInvalidUsernameTooShort() {
        assertFalse(UserValidator.isValidUsername("jo"), "Username less than 5 characters should return false");
    }

    @Test
    void testInvalidUsernameEmpty() {
        assertFalse(UserValidator.isValidUsername(""), "Empty username should return false");
    }

    @Test
    void testInvalidUsernameNull() {
        assertFalse(UserValidator.isValidUsername(null), "Null username should return false");
    }
}
