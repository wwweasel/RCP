package de.wwweasel.RCP;

public enum Profession {
	
	MODELING(6000),
	RIGGING(7000),
	ANIMATION(6700),
	TEXTURING(6700),
	LIGHTING(6777),
	COMPOSITING(7000);
	
	protected final int salary;
	private Profession(int salary) {
		this.salary = salary;
	}
	public int getSalary() {return salary;}
	
	
}
