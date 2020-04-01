package de.wwweasel.RCP;

public enum Profession {

	MODELING(5500),
	RIGGING(6000),
	ANIMATION(5300),
	LIGHTING(5400),
	TEXTURING(4700),
	COMPOSITING(5400)
	;
	
	private int salary;
	private Profession(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

//MODELING,
//RIGGING,
//ANIMATION,
//LIGHTING,
//TEXTURING,
//COMPOSITING
//;
