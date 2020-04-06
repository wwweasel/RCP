package de.wwweasel.RCP;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
		
	public Employee createEmployee(String name ,String surname, Profession profession) {
		return new Employee(name,surname,profession,profession.getSalary());
	}

	public Employee save(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> findAll(){
		return repo.findAll();
	}

	public Optional<Employee> findById(Integer id) {
		Optional<Employee> oEmployee = repo.findById(id);
		return oEmployee;
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	public List<Employee> findByProfession( Profession profession){
		return repo.findByProfession(profession);
	}
	
}
