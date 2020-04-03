package de.wwweasel.RCP;

public enum Profession {
	
	MODELING(5700),
	RIGGING(6000),
	ANIMATION(5700),
	LIGHTING(5400),
	TEXTURING(6000),
	COMPOSITING(5400)
	;
	
	private int salary;
	private Profession( int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	
}
