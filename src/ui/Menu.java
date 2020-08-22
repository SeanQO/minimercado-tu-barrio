package ui;
import model.*;
import java.util.*;

public class Menu {
	private static String ASTERISKS = "*****************";	
	private Store store;
	private Scanner in;
	
	public Menu() {
		store = new Store();
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
			
			
			break;
		case 2:
			
			break;
			
		case 3:
			
			break;

		default:
			System.out.println("-\n"+ASTERISKS);
			System.out.println("Not a valid option. \nPlease only type the number next to the option (1,2 or 3)\n-");
			break;
		}
		return exit;
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
				System.err.println("*Exception*\n" + numberFormatException);

			} 
			
			exit = runOption(option);
		} while (!exit);
		
	}
	
}
