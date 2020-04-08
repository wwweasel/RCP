package de.wwweasel.RCP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method=RequestMethod.GET,value="/")
	public String start( Model model, @RequestParam(required = false, defaultValue = "none") String filter, @RequestParam(required = false) Integer[] employeeIds) {//, @ModelAttribute("editError") String editError
		
		switch (filter) {
		case "findByProfession":
			model.addAttribute("employees", employeeService.findByProfession(employeeIds));
			break;
			
		case "findByIds":
			model.addAttribute("employees", employeeService.findByIds(employeeIds).getEmployees());
			break;
			
		case "none":
			model.addAttribute("employees", employeeService.findAll());
			break;
			
		default:
			model.addAttribute("employees", employeeService.findAll());
			break;
		}
		
		model.addAttribute("editError", "Theres supposed to be an Error");
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("professions", Profession.values() );//Add all the values of Profession for a DropDown 
		return "add";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		employeeService.save( employee );
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/edit")
	public String editEmployee(@RequestParam(required = false) Integer[] employeeIds, Model model) {
		
		if(employeeIds!=null) {
			EmployeeDTO dto = employeeService.findByIds(employeeIds);
			model.addAttribute("employeesDTO",dto);
			return "edit";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/edit")
	public String editEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
		for (Employee employee : employeeDTO.getEmployees()) {
			System.out.println("Save: " + employee);
			employeeService.save(employee);
		}
		return "redirect:/";
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/delete")
	public String deleteEmployee(@RequestParam Integer[] employeeIds) {
		for (int i = 0; i < employeeIds.length; i++) {
			employeeService.deleteById(employeeIds[i]);
		}
		return "redirect:/";
	}
	
//	@RequestMapping(method=RequestMethod.GET,value="/find/{ids}")
//	public ArrayList<Employee> getAllEmployees(@PathVariable int[] ids ) {
//		ArrayList<Employee> list = new ArrayList<Employee>();
//		for (int id : ids) {
//			list.add( employeeService.findById(id).get() );
//		}
//		return list;
//	}

}
