package de.wwweasel.RCP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	
	protected String name;
	protected String surname;
	protected float salary;
	protected Profession profession;
	
	public Employee() {}
	
	public Employee( String name ,String surname, Profession profession, float salary) {
		
		this.name = name;
		this.surname = surname;
		this.profession = profession;
		this.salary = salary;
	}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getSurname() {return surname;}

	public void setSurname(String surname) {this.surname = surname;}

	public float getSalary() {return salary;}
	
	public void setSalary(float salary) {this.salary = salary;}

	public Profession getProfession() { return profession; }
	
	public void setProfession(Profession profession) { this.profession = profession; }
	
	public int getId() {return id;}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", profession=" + profession + ", salary=" + salary + "]";
	}
	
	
	
	
	
}
