package exceptions;

import java.io.IOException;

public class DoesNotExistException extends IOException {
	public DoesNotExistException (){
		super("The image does not exist.");
	}
	
}