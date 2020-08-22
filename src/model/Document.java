package model;

public enum Document{
	TI(true),
	CC(false),
	PP(false),
	CE(false);
	
	private boolean underAge;
	Document(boolean underAge) {
		this.underAge = underAge;
	}
	
	public boolean getAge() {
		return underAge;
	}

}
