/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class LoginValidatorTest {

   
    @Test
    void testValidUsername() {
        assertTrue(LoginValidator.isValidUsername("User123"));
    }

  
    @Test
    void testUsernameWithSpecialCharacters() {
        assertFalse(LoginValidator.isValidUsername("User@123"));
    }

   
    @Test
    void testUsernameTooShort() {
        assertFalse(LoginValidator.isValidUsername("Usr"));
    }

   
    @Test
    void testEmptyUsername() {
        assertFalse(LoginValidator.isValidUsername(""));
    }

   
    @Test
    void testNullUsername() {
        assertFalse(LoginValidator.isValidUsername(null));
    }
}
