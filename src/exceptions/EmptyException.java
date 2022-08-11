package exceptions;

import java.lang.Exception;

public class EmptyException extends Exception {
	public EmptyException (){
		super("all fields left empty");
	}
}