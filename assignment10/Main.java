// The password's length is between 8 and 16 (inclusive)
// and 3/4
// lower case letters, i.e., a-z
// upper case letters, i.e., A-Z
// numbers
// the following special symbols: ~!@#$%^&*()-=+_
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		int checks = 0;
		String password = args[0];
		
		if ((password.length() <= 8) || (password.length() >= 16)) {
			System.out.println("Password is not correct length\nLength: " + password.length());
			System.exit(1);
		}
		if (checkBadChars(password)) {
			System.out.println("Bad characters in password\nPassword not accepted");
			System.exit(1);
		}


		if (checkLowerCase(password)) {
			checks += 1;
		}
		if (checkUpperCase(password)) {
			checks += 1;
		}
		if (checkNumbers(password)) {
			checks += 1;
		}
		if (checkSymbols(password)) {
			checks += 1;
		}

		if (checks >= 3) {
			System.out.println("Password accepted");
		} else if (checks < 3) {
			System.out.println("Password not accepted");
		}
	}
	public static boolean checkBadChars(String pass) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9~!@#$%^&*()\\-=_+]+");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean checkLowerCase(String pass) {
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean checkUpperCase(String pass) {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
		public static boolean checkNumbers(String pass) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
		public static boolean checkSymbols(String pass) {
		Pattern pattern = Pattern.compile("[~!@#$%^&*()\\-=_]");
		Matcher matcher = pattern.matcher(pass);

		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
}