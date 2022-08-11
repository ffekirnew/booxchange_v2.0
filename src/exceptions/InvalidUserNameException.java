package exceptions;

import java.lang.Exception;

public class InvalidUserNameException extends Exception {
	public InvalidUserNameException (){
		super("such username doesn't exist");
	}
}