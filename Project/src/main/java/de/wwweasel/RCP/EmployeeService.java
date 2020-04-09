package de.wwweasel.RCP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.EmployeesDTO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
		
	public Employee createEmployee(String name ,String surname, ProfessioN profession) {
		return new Employee(name,surname,profession,profession.getSalary());
	}

	public Employee save(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> findAll(){
		return repo.findAll();
	}
	
	public EmployeesDTO findByIds(Integer[] employeeIds) {
		EmployeesDTO dto = new EmployeesDTO();
		for (int i = 0; i < employeeIds.length; i++) {
			Optional<Employee> oEmployee = repo.findById(employeeIds[i]);
			if(oEmployee.isPresent()) {
				Employee employee = oEmployee.get();
				dto.addEmployee(employee);
			}else {
				System.out.println("findByIds() -> Could not find Employee with ID: " + employeeIds[i]);
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
			Optional<Employee> employeeO = repo.findById(employeeIds[i]);
			if(employeeO.isPresent()) {
				Employee employee = employeeO.get();
				for (Employee e : employee.getProfession().getEmployees()) {
					employees.add(e);
				}
			}else {
				System.out.println("findByProfession() -> Could not find Employee with ID: " + employeeIds[i]);
			}
		}
		
		return employees;
	}
	
}
