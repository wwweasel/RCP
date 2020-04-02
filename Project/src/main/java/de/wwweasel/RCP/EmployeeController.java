package de.wwweasel.RCP;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String start( Model model) {
		model.addAttribute("employees", repo.findAll());
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
		repo.save(employee);
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/edit/{id}/{name}/{surname}")
	@ResponseBody
	public Iterable<Employee> addEmployee(@PathVariable int id, @PathVariable String name, @PathVariable String surname) {
		Employee e = repo.findById(id).get();
		e.setName(name);
		e.setSurname(surname);
		repo.save(e);
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/delete")//{ids}
	public String deleteEmployee(@ModelAttribute Employee employee) {
		System.out.println("id: " + employee);
		repo.deleteById(employee.getId());

		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/find/all")
	@ResponseBody
	public Iterable<Employee> getEmployee() {
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/find/{ids}")
	@ResponseBody
	public ArrayList<Employee> getAllEmployees(@PathVariable int[] ids ) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		for (int id : ids) {
			list.add( repo.findById(id).get() );
		}
		return list;
	}

}
