package ftm;

import java.util.regex.Pattern;

public class EmailValidation {
	
		public static String validateEmail(String email) {
			if(email==null || email.isEmpty()) {
				return "invalid";
			}
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(emailRegex);
			if(pattern.matcher(email).matches()) {
				return "valid";
			}
			else {
				return "invalid";
			}
		}
	

	public static void main(String[] args) {
		EmailValidation em = new EmailValidation();
	}

}
