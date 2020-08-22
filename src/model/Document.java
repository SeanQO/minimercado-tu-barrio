package model;

public enum Document{
	TI(false),
	CC(true),
	PP(true),
	CE(true);
	
	private boolean age;
	Document(boolean age) {
		this.age = age;
	}
	
	public boolean getAge() {
		return age;
	}

}
