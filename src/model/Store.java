package model;
import java.util.*;
import java.time.LocalDate;
import exceptions.*;

public class Store {
	private ArrayList<Person> entries;
	private int totalVisitors;
	
	public Store(){
		entries = new ArrayList<Person>();
		totalVisitors = 0;
	}
	
	public int getTotalVisitors() {
		return totalVisitors;
	}
	
	public String registerVisitors(Document document, long idNumber) throws InvalidNumberException, InvalidTypeException{
		String message = "\n";
		Person person = new Person(document, idNumber);
		
		totalVisitors ++;
		if (document.getAge()) {
			if ( picoYCedula(idNumber) ) {
				entries.add(person);
				message ="Person can enter minimarket";
			}else {
				
				throw new InvalidNumberException( LocalDate.now().getDayOfMonth() );
			}
			
		}else {
			throw new InvalidTypeException();
		}
		
		return "Registration completed, "+ message;
	}
	
	private boolean picoYCedula(long idNumber) {
		boolean picoYCedula = false;
		int dayOfMonth = LocalDate.now().getDayOfMonth(); 
		String stringIdNumber = Long.toString(idNumber);
		int idLastNumber = stringIdNumber.charAt(stringIdNumber.length()-1);
		switch (dayOfMonth%2) {
		case 0:
			if (idLastNumber%2 == 0) {
				picoYCedula = true;
			}
			break;
			
		default:
			if (idLastNumber%2 != 0) {
				picoYCedula = true;
			}
			break;
		}
		return picoYCedula;
	}
	
	public String getRegisteredPerson(long idNumber ) {
		return "";
	}
	
}
