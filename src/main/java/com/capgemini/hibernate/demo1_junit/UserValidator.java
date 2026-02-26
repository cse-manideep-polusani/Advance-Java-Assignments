package com.capgemini.hibernate.demo1_junit;

import java.util.Scanner;

public class UserValidator {
	static boolean isValidUsername(String username) {
		if (username == null || username.isEmpty()) {
			return false;
		}
		// Username must be 5-15 characters and contain only letters and numbers
		return username.matches("^[a-zA-Z0-9]{5,15}$");
	}

	static boolean isValidPassword(String password) {
		if (password == null || password.isEmpty()) {
			return false;
		}
		// Password must be at least 8 characters, include a digit, a letter, and a
		// special character
		return password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("username: ");
		String username = scanner.nextLine();

		System.out.print("password: ");
		String password = scanner.nextLine();

		if (isValidUsername(username) && isValidPassword(password)) {
			System.out.println("Logged In");
		} else {
			System.out.println("Invalid username/password! ");
		}

		scanner.close();
	}

}
