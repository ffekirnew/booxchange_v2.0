package exceptions;

import java.lang.Exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException (){
		super("email does not conform to the right standards");
	}
}