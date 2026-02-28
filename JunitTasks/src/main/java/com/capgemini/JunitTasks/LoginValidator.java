/**
 * 
 */
package com.capgemini.JunitTasks;

/**
 * 
 */


public class LoginValidator {

 
    public static boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (username.length() < 5 || username.length() > 15) {
            return false;
        }

      
        return username.matches("[a-zA-Z0-9]+");
    }

   
    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[@$!%*?&].*");

        return hasLetter && hasDigit && hasSpecial;
    }

  
    public static String login(String username, String password) {
        if (!isValidUsername(username)) {
            return "Invalid Username";
        }

        if (!isValidPassword(password)) {
            return "Invalid Password";
        }

        return "Login Successful";
    }
}

