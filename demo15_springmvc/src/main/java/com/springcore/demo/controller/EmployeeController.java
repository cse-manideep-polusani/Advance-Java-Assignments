package com.springcore.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import com.springcore.demo.service.EmployeeService;
import com.springcore.demo.model.Employee;

@Controller
public class EmployeeController {
	public EmployeeService empService;
	
	public EmployeeController(EmployeeService empService) {
		this.empService=empService;
	}
	
	@GetMapping("/employees")
	public String getEmployeeDetails(Model model) {
		List<Employee> employees = empService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "employee";
	}
	
	//Model,ModelAndView,ModelMap,ModelAttribute
//	@GetMapping("/employees")
//	public ModelAndView getAllEmployees() {
//		List<Employee> employee = emService.getAllEmployees();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("employee",employee);
//		mv.setViewName("employee");
//		return mv;
//	}
	
	@GetMapping("/addEmployee")
	public String showAddForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/editEmployee/{id}")
	public String showEditForm(@PathVariable Long id,Model model) {
		Employee employee = empService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		empService.deleteEmployee(id);
		return "redirect:/employees";
	}
}
