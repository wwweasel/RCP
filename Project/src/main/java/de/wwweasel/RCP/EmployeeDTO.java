package de.wwweasel.RCP;

import java.util.ArrayList;


public class EmployeeDTO {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public ArrayList<Employee> getEmployees() {return employees;}

	public void setEmployees(ArrayList<Employee> employees) {this.employees = employees;}
	
	public void addEmployee(Employee employee) { this.employees.add(employee); }
	
}
