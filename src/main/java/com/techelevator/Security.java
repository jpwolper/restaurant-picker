package com.techelevator;

import com.techelevator.model.User;

public class Security {

	public boolean IsUserValid(User user, String password, byte[] salt) {
		
		PasswordHasher hasher = new PasswordHasher();		
		String hash = hasher.computeHash(password, salt);
		
		return hash == user.getPassword();
	}
}
