package de.wwweasel.RCP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="required")
	protected String name;
	@NotBlank(message="required")
	protected String surname;
	
	@ManyToOne
	protected ProfessioN profession;
	
	public Employee() {}
	
	public Employee( String name ,String surname, ProfessioN profession, float salary) {
		
		this.name = name;
		this.surname = surname;
		this.profession = profession;
	}
	
	public Integer getId() {return id;}
	
	public void setId(Integer id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getSurname() {return surname;}

	public void setSurname(String surname) {this.surname = surname;}


	public ProfessioN getProfession() { return profession; }
	
	public void setProfession(ProfessioN profession) { this.profession = profession; }
	

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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", profession=" + profession + "]";
	}
	
	
	
	
	
}
