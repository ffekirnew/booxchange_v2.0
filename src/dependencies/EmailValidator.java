package dependencies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private String email;
	public EmailValidator(String email){
		this.email = email;
	}

	public boolean validate() {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);
        boolean matchFound = matcher.find();

		return matchFound;
	}
}