package controller;

import library.BCrypt;

public class Decode {
	//method for decode password by Bcrypt
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}
	public static void main(String[] args) {
		String password = "123456"; 
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println(hashed);
		
		//c1
		System.out.println("Đúng hay sai đây?  " + checkPassword(password, hashed));
		
	}
}
