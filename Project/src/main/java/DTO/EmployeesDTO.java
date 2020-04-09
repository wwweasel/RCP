package DTO;

import java.util.ArrayList;

import de.wwweasel.RCP.Employee;

public class EmployeesDTO {
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) { employees.add(employee); }

	public ArrayList<Employee> getEmployees() {return employees;}

	public void setEmployees(ArrayList<Employee> employees) {this.employees = employees;}
	
}
