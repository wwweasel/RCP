package de.wwweasel.RCP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RcpApplication.class, args);
		
		Employee employee = EmployeeFactory.getEmployee( "Hans", "Dieter", Profession.RIGGING );
		System.out.println(employee);
		Employee employee2 = EmployeeFactory.getEmployee( "Peter", "Latz", Profession.ANIMATION );
		System.out.println(employee2);
	}

}
