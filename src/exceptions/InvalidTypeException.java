package exceptions;

@SuppressWarnings("serial")
public class InvalidTypeException extends Exception{

	public InvalidTypeException() {
		super("the id type doesnt match with the requred type to enter");
	}

}
