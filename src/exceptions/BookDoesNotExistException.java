package exceptions;

import java.lang.Exception;

public class BookDoesNotExistException extends Exception {
	public DoesNotExistException (){
		super("The book does not exist.");
	}
}