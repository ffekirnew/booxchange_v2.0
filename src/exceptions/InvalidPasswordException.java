package exceptions;

import java.lang.Exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException (){
		super("password is not correct");
	}
}