package de.wwweasel.RCP;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	//List<Employee> findByProfession(Profession profession);
}
