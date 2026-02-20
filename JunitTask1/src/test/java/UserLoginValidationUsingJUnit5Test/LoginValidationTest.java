package UserLoginValidationUsingJUnit5Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import UserLoginValidationUsingJUnit5.LoginValidation;
public class LoginValidationTest {
	private LoginValidation loginValidation;
	
	@BeforeEach
	public void setUp() {
		loginValidation = new LoginValidation();
	}
	
	@ParameterizedTest
	@CsvSource({
		"mani, Mani@nsbnsj , Invalid Username and Password",
	    "Manideep, Mani@9989, Login Successful",
	    "Mani@Deep, Mani@111, Invalid Username",
	    "Hello1000, nibn@ibneb, Invalid Password",
	    "'', huhub@jd11, Invalid Username"
	})
	void testValidator(String user, String pass, String expected) {
	    assertEquals(expected, loginValidation.loginDecision(user, pass));
	}
	
	@ParameterizedTest
	@CsvSource(
	    value = {
	        "NULL, Mani@1234, Invalid Username",
	        "Manideep, NULL, Invalid Password",
	        "NULL, NULL, Invalid Username and Password"
	    },
	    nullValues = "NULL"
	)
	void testNullCases(String user, String pass, String expected) {
	    assertEquals(expected, loginValidation.loginDecision(user, pass));
	}

}
