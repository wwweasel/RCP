package de.wwweasel.RCP;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	// Creates a SQL Query that Joins the two tables together and finds the employees with the given ProfessioN  
	List<Employee> findByProfession(ProfessioN profession);
}
