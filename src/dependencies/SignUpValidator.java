package dependencies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import exceptions.*;

public class SignUpValidator {
	
	private JTextField[] textFields;
	private String email;
	private String[] passFields = new String[2];

	public SignUpValidator(JTextField[] textFields, JTextField emailField, JPasswordField[] passFields){
		this.textFields = textFields;
		this.email = emailField.getText();
		int index = 0;
		for (JPasswordField p : passFields) {
			this.passFields[index] = p.getText();
			index++;
		}
	}

	public void validate() throws EmptyException, InvalidEmailException, InvalidPasswordException {
		this.checkEmptyFields();
		this.checkInvalidPassword();
		this.checkEmail();
	}

	private void checkEmptyFields() throws EmptyException {
		JTextField[] componentSet = this.textFields;
		for (JTextField c : componentSet) {
			if (c.getText().equals(""))
				throw new EmptyException();
		}
	}

	private void checkInvalidPassword() throws InvalidPasswordException {
		if (!passFields[0].equals(passFields[1]))
			throw new InvalidPasswordException();
	}

	private void checkEmail() throws InvalidEmailException {


		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.email);
        boolean matchFound = matcher.find();

		if (!matchFound)
			throw new InvalidEmailException();
	}
	
}