package de.wwweasel.RCP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfessioN {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	protected final String title;
	protected int salary;
	
	// Constructor
	public ProfessioN(String title, int salary) {
		this.title = title;
		this.salary = salary;
	}
	
	// Getters and Setters
	public int getSalary() {return salary;}

	public void setSalary(int salary) {this.salary = salary;}

	public Integer getId() {return id;}

	public String getTitle() {return title;}

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
	
	
	
	
}
