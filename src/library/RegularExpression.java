package library;

public class RegularExpression {
	public static boolean checkNumber(String number) {
		return number.matches("^\\d+$");
	}
}
