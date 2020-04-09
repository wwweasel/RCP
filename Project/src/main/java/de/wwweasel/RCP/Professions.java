package de.wwweasel.RCP;

public enum Professions {
	
	MODELING(6000),
	RIGGING(6000),
	ANIMATION(6000),
	LIGHTING(6000),
	TEXTURING(6000),
	COMPOSITING(6000);
	
	protected int salary;
	private Professions(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	
	
}
