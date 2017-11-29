package library;

public class demo {
	public static void main(String[] args) {
		String password = "123456";
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));
		System.out.println(hashed);
	}
}
