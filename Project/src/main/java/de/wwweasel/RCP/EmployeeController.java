package de.wwweasel.RCP;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method=RequestMethod.GET,value="/")
	public String start( Model model, @ModelAttribute("editError") String editError) {
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("editError", editError);
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
	
	@RequestMapping(method=RequestMethod.GET,value="/edit/{id}")
	public ModelAndView editEmployee(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		Optional<Employee> oEmployee = employeeService.findById(id);
		if(oEmployee.isPresent()) {
			Employee employee = oEmployee.get();
			mv.addObject("employee", employee);
			mv.setViewName("edit");
			
		}else {
			String editError = "Could not find Employee with ID: " + id; 
			mv.addObject("editError",editError);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/edit")
	public String editEmployee(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	public String deleteEmployee(@RequestParam Integer id) {
		employeeService.deleteById(id);
		return "redirect:/";
	}
	
//	@RequestMapping(method=RequestMethod.GET,value="/find/{ids}")
//	@ResponseBody
//	public ArrayList<Employee> getAllEmployees(@PathVariable int[] ids ) {
//		ArrayList<Employee> list = new ArrayList<Employee>();
//		for (int id : ids) {
//			list.add( employeeService.findById(id).get() );
//		}
//		return list;
//	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findByProfession")
	@ResponseBody
	public List<Employee> findByProfession(@RequestParam String profession) {
		return employeeService.findByProfession(Profession.valueOf(profession));
	}

}
