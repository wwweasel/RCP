package de.wwweasel.RCP;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProfessioN {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	protected String profession;
	protected int salary;
	
	//@OneToMany(mappedBy = "profession")
	//private final List<Employee> employees = new ArrayList<>();
	
	// Constructors
	public ProfessioN(){}
	
	public ProfessioN(String profession, int salary) {
		this.profession = profession.toUpperCase();
		this.salary = salary;
	}
	
	// Getters and Setters
	public Integer getId() {return id;}
	
	public String getProfession() {return profession;}
	
	public void setProfession(String profession) {this.profession = profession.toUpperCase();}
	
	public int getSalary() {return salary;}

	public void setSalary(int salary) {this.salary = salary;}

	//public List<Employee> getEmployees() {return employees;}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessioN other = (ProfessioN) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProfessioN [id=" + id + ", profession=" + profession + ", salary=" + salary + "]";
	}
	
}
