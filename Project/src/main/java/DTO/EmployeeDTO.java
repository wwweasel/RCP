package DTO;

import java.util.ArrayList;

import de.wwweasel.RCP.Employee;


public class EmployeeDTO {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public ArrayList<Employee> getEmployees() {return employees;}

	public void setEmployees(ArrayList<Employee> employees) {this.employees = employees;}
	
	public void addEmployee(Employee employee) { this.employees.add(employee); }
	
}
