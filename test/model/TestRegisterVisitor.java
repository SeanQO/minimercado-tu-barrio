package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import exceptions.InvalidNumberException;
import exceptions.InvalidTypeException;

class TestRegisterVisitor {
	
	private Store minimarketTest;
	
	public void setUpStageOne() {
		minimarketTest = new Store();
	}
	
	@Test
	void testRregisterVisitors() {
//******************************* test for an adult with pair id (both not registered and registered) *****************************************
		setUpStageOne();
		Document documentTest = Document.valueOf("CC");
		try {
			minimarketTest.registerVisitors(documentTest, 1886169712 );
			assertEquals(1, minimarketTest.getTotalVisitors(),"The visitor was registered"
					+ " but was not added to the visitors count.");
			
		} catch (InvalidNumberException invalidNumberException) {
			if (LocalDate.now().getDayOfMonth()%2 == 0) {
				fail("invalidNumberException not expected.\nthe document(pair) should be allowed to enter on this day(pair)");
			}else {
				assertEquals(1, minimarketTest.getTotalVisitors(),"The visitor was not registered(id type didnt match) "
						+ " but was not added to the visitors count.");
			}
			
		}catch (InvalidTypeException invalidTypeException) {
			fail("invalidTypeException not expected.\nThe document registered does not match the type expected");
		}

//******************************* test for an adult with odd id (both not registered and registered) *****************************************

		setUpStageOne();
		documentTest = Document.valueOf("PP");
		try {
			minimarketTest.registerVisitors(documentTest, 1886169713 );
			assertEquals(1, minimarketTest.getTotalVisitors(),"The visitor was registered"
					+ " but was not added to the visitors count.");
			
		} catch (InvalidNumberException invalidNumberException) {
			if (LocalDate.now().getDayOfMonth()%2 == 0) {
				assertEquals(1, minimarketTest.getTotalVisitors(),"The visitor was not registered(id type didnt match) "
						+ " but was not added to the visitors count.");
				
			}else {
				fail("invalidNumberException not expected.\nthe document(odd) should be allowed to enter on this day(odd)");
				
			}
			
		}catch (InvalidTypeException invalidTypeException) {
			fail("invalidTypeException not expected.\nThe document registered does not match the type expected");
		}

//******************************* test, not registering an under age *****************************************		

		setUpStageOne();
		documentTest = Document.valueOf("TI");
		try {
			minimarketTest.registerVisitors(documentTest, 1886169713 );
			fail("the registration of an under age should trow an invalidTypeException.");
			
		} catch (InvalidNumberException invalidNumberException) {
				fail("invalidNumberException not expected.\nthe document type from an under age should not generate the invalidNubmerException");

		}catch (InvalidTypeException invalidTypeException) {
			assertEquals(1, minimarketTest.getTotalVisitors(),"The visitor was not registered(id type mismatch)"
					+ " but was not added to the visitors count.");
		}
		
	}
	
	

}
