package ui;
import model.*;
import java.util.*;
import exceptions.*;

public class Menu {
	private static String ASTERISKS = "*****************";	
	private Store minimarket;
	private Scanner in;
	
	public Menu() {
		minimarket = new Store();
		in = new Scanner(System.in);

	}
	
	private void showMenu() {
		System.out.println(ASTERISKS);
		System.out.println("*PRINCIPAL MENU*");
		System.out.println(ASTERISKS);
		System.out.println("1.Register person");
		System.out.println("2.Total visitors");
		System.out.println("3. Exit");
	}
	
	private boolean runOption(int option) {
		boolean exit = false;
		switch (option) {
		case 1:
			runOptionOne();
			break;
			
		case 2:
			System.out.println("\n"+ ASTERISKS);
			System.out.println("total visitors = "+ minimarket.getTotalVisitors());
			break;
			
		case 3:
			exit = true;
			break;

		default:
			System.out.println("-\n"+ASTERISKS);
			System.out.println("Not a valid option. \nPlease only type the number next to the option (1,2 or 3)\n-");
			break;
		}
		
		System.out.println(ASTERISKS);
		System.out.println("press any key to continue.");
		in.nextLine();
		return exit;
	}
	
	private void runOptionOne() {
		Document document = Document.valueOf("CC");
		boolean exit = false;
		long idNumber = 0;
		do {
			System.out.println("\n" + ASTERISKS
					+ "\nEnter the id type (upper/ lower case, or both): "
					+ "\n TI for tarjeta de identidad "
					+ "\n CC for cedula de ciudadania "
					+ "\n PP for pasaporte "
					+ "\n CE for cedula de ciudadania ");
			
			try {
				
				String documentType = in.nextLine();
				System.out.println(documentType.toUpperCase()+"******************");
				document = Document.valueOf(documentType.toUpperCase());
				
				System.out.println("\n"+ASTERISKS
						+"\nEnter the id number: ");
				idNumber = Long.parseLong(in.nextLine());
				
				exit = true;
				
			} catch (NumberFormatException numberFormatException) {
				System.out.println("\n"+ASTERISKS);
				
				//System.err.println("*Exception*\n" + numberFormatException);
				
				System.out.println("Invalid id number. \nPlease enter a valid id number");
				
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println("\n"+ASTERISKS);
				
				//System.err.println("*Exception*\n" + illegalArgumentException);
				
				System.out.println("Invalid id type. \nplease enter one of the shown options(TI,CC,PP or CE)");
			}
		} while (!exit);
		
		try {
			System.out.println("\n"+ASTERISKS);
			System.out.println(minimarket.registerVisitors(document,idNumber));
			
		} catch (InvalidNumberException invalidNumberException) {
			System.out.println("\n"+ASTERISKS);
			//System.err.println("*Exception*\n" + invalidNumberException);
			System.out.println("The id number doesnt match with todays pico y cedula. \n the visitor data was not saved.");
			
		}catch (InvalidTypeException invalidTypeException) {
			System.out.println("\n"+ASTERISKS);
			//System.err.println("*Exception*\n" + invalidTypeException);
			System.out.println("The person must be an adult(+18) to enter the store. \n the visitor data was not saved.");
			
		}
		
	}
	
	public void startProgram() {
		boolean exit = false;
		int option = 0;
		System.out.println("\n"+ASTERISKS);
		System.out.println("*****WELCOME*****");
		do {
			try {
				showMenu();
				option = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException numberFormatException) {
				System.out.println("\n"+ASTERISKS);
				
				//System.err.println("*Exception*\n" + numberFormatException);
				
				option = 0;
			} 
			
			exit = runOption(option);
		} while (!exit);
		
		
	}
	
}
