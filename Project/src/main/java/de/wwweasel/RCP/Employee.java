package de.wwweasel.RCP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee{
	
	// fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	protected String name;
	protected String surname;
	protected float salary;
	protected Profession profession;
	
	// Constructors
	public Employee() {}
	
	public Employee( String name ,String surname, Profession profession, float salary) {
		
		this.name = name;
		this.surname = surname;
		this.profession = profession;
		this.salary = salary;
	}
	
	// methods
	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getSurname() {return surname;}

	public void setSurname(String surname) {this.surname = surname;}

	public float getSalary() {return salary;}
	
	public void setSalary(float salary) {this.salary = salary;}

	public Profession getProfession() { return profession; }
	
	public void setProfession(Profession profession) { this.profession = profession; }
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", profession=" + profession + ", salary=" + salary + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}	
	
}
