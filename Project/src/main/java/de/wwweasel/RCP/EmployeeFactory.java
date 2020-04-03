package de.wwweasel.RCP;


public class EmployeeFactory {
		
	public EmployeeFactory() {}
	
	public static Employee getEmployee(String name ,String surname, Profession profession) {
		
		Employee employee;
		
		switch (profession)
	    { 
	    case MODELING: 
	    	employee =  new Employee(name,surname,profession,9000); 
	        break; 
	    case RIGGING: 
	    	employee =  new Employee(name,surname,profession,7000); 
	        break;
	    case ANIMATION: 
	    	employee =  new Employee(name,surname,profession,6000); 
	        break; 
	    case LIGHTING: 
	    	employee =  new Employee(name,surname,profession,3900);
	    	break;
	    case TEXTURING: 
	    	employee =  new Employee(name,surname,profession,3900); 
	        break;
	    case COMPOSITING: 
	    	employee =  new Employee(name,surname,profession,4700); 
	        break;
	    default: 
	    	employee = null; 
	        break; 
	    } 
		
		return employee; 
		
	}
	
}
