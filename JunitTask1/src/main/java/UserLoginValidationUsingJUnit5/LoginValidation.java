package UserLoginValidationUsingJUnit5;

public class LoginValidation {
	public boolean usernameValidation(String username) {
		if (username == null || username.length() < 6 || username.length() > 14) {
			return false;
		}
		for (int i = 0; i < username.length(); i++) {
			char ch = username.charAt(i);
			if (!(Character.isLetterOrDigit(ch))) {
				return false;
			}
		}
		return true;
	}

	public boolean passwordValidation(String password) {

	    if (password == null || password.length() < 8) {
	        return false;
	    }

	    boolean hasAlphabet = false;
	    boolean hasDigit = false;
	    boolean hasSpecial = false;

	    for (int i = 0; i < password.length(); i++) {
	        char ch = password.charAt(i);

	        if (Character.isLetter(ch)) {
	            hasAlphabet = true;
	        } 
	        else if (Character.isDigit(ch)) {
	            hasDigit = true;
	        } 
	        else if ("@$!%*?&".indexOf(ch) != -1) {
	            hasSpecial = true;
	        }
	    }
	    return hasAlphabet && hasDigit && hasSpecial;
	}
	
	public String loginDecision(String username, String password) {
	    if (!(usernameValidation(username)) && (!(passwordValidation(password))) ) {
	    	return "Invalid Username and Password";
	    }
		
	    if (!usernameValidation(username)) {
	        return "Invalid Username";
	    }

	    if (!passwordValidation(password)) {
	        return "Invalid Password";
	    }

	    return "Login Successful";
	}
}
