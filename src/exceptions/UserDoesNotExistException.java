package exceptions;

import java.lang.Exception;

public class UserDoesNotExistException extends Exception {
	public DoesNotExistException (){
		super("The user does not exist.");
	}
}