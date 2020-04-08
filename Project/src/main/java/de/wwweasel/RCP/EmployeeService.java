package de.wwweasel.RCP;

import java.util.ArrayList;
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

//	public Optional<Employee> findById(Integer id) {
//		Optional<Employee> oEmployee = repo.findById(id);
//		return oEmployee;
//	}
	
	public EmployeeDTO findByIds(Integer[] employeeIds) {
		EmployeeDTO dto = new EmployeeDTO();
		for (int i = 0; i < employeeIds.length; i++) {
			Optional<Employee> oEmployee = repo.findById(employeeIds[i]);
			if(oEmployee.isPresent()) {
				Employee employee = oEmployee.get();
				dto.addEmployee(employee);
			}else {
				System.out.println("Could not find Employee with ID: " + employeeIds[i]);
			}
		}
		return dto;
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}
	
	
	public ArrayList<Employee> findByProfession( Integer[] employeeIds){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < employeeIds.length; i++) {
			Profession profession = repo.findById(employeeIds[i]).get().getProfession();
			List<Employee> current_profession_list = repo.findByProfession(profession);
			for (Employee e : current_profession_list) {
				employees.add(e);
			}
		}
		return employees;
	}
	
}
