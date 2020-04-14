package DTO;

import java.util.ArrayList;

import javax.validation.Valid;

import de.wwweasel.RCP.Employee;

public class EmployeesDTO {
	ArrayList<@Valid Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) { employees.add(employee); }

	public ArrayList<Employee> getEmployees() {return employees;}

	public void setEmployees(ArrayList<Employee> employees) {this.employees = employees;}
	
}
