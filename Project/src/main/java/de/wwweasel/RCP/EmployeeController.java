package de.wwweasel.RCP;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DTO.EmployeesDTO;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	ProfessioNService professioNService;

	@RequestMapping(method=RequestMethod.GET,value="/")
	public String start( Model model, @RequestParam(required = false, defaultValue = "removeFilter") String filter, @RequestParam(required = false) Integer[] employeeIds) {//, @ModelAttribute("editError") String editError
		
		switch (filter) {
		case "findByProfession":
			if(employeeIds!=null) {
				model.addAttribute("employees", employeeService.findByProfession(employeeIds));
			}else {
				model.addAttribute("employees", employeeService.findAll());
			}
			break;
			
		case "findByIds":
			if(employeeIds!=null) {
				model.addAttribute("employees", employeeService.findByIds(employeeIds).getEmployees());
			}else {
				model.addAttribute("employees", employeeService.findAll());
			}
			break;
			
		case "removeFilter":
			model.addAttribute("employees", employeeService.findAll());
			break;
			
		default:
			model.addAttribute("employees", employeeService.findAll());
			break;
		}
		
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/add")
	public String addEmployee(Model model) {		
		model.addAttribute("employee", new Employee());
		model.addAttribute("professions", professioNService.findAll() );
		return "add";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public String addEmployee(@ModelAttribute @Valid Employee employee, Errors errors, Model model) {
		if(errors.hasErrors()){
			model.addAttribute("professions", professioNService.findAll() );
			return "add";
		}else{
			employeeService.save( employee );
			return "redirect:/";
		}	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/edit")
	public String editEmployee(@RequestParam(required = false) Integer[] employeeIds, Model model) {
		if(employeeIds!=null) {
			EmployeesDTO dto = employeeService.findByIds(employeeIds);
			model.addAttribute("employeesDTO",dto);
			model.addAttribute("professions", professioNService.findAll() );
			return "edit";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/edit")
	public String editEmployee(@ModelAttribute @Valid EmployeesDTO employeeDTO, Errors errors, Model model) {
		if(errors.hasErrors()){
			model.addAttribute("professions", professioNService.findAll() );
			return "edit";
		}else{
			for (Employee employee : employeeDTO.getEmployees()) {
				System.out.println("Save: " + employee);
				employeeService.save(employee);
			}
			return "redirect:/";
		}	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/delete")
	public String deleteEmployee(@RequestParam(required = false) Integer[] employeeIds) {
		if(employeeIds!=null) {
			for (int i = 0; i < employeeIds.length; i++) {
				employeeService.deleteById(employeeIds[i]);
			}
		}
		return "redirect:/";
	}

}
