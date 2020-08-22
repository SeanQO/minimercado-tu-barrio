package model;

public class Person {
	private Document document;
	private long idNumber;
	
	public Person(Document document, long idNumber) {
		this.document = document;
		this.idNumber = idNumber;
	}
	
	public Document getDocument() {
		return document;
	}
	
	public long getIdNumber() {
		return idNumber;
	}
	
}
