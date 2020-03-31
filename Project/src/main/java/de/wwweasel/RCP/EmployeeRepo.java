package de.wwweasel.RCP;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	//Employee findByProfession(Profession profession);
}
