package exceptions;

@SuppressWarnings("serial")
public class InvalidNumberException extends Exception{
	
	public InvalidNumberException(int dayOfMonth) {
		super("the id number doesnt match with todays ("+ dayOfMonth +") pico y cedula.");
	}
	

}
