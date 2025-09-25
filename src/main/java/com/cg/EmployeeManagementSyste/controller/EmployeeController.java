package com.cg.EmployeeManagementSyste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.EmployeeManagementSyste.entity.Employee;
import com.cg.EmployeeManagementSyste.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public String homePage(Model model) {
	    model.addAttribute("employees", service.getAllEmployees());
	    return "index";
	}
	
	@GetMapping("/showAddForm")
	public String createEmployeeForm(Model model)
	{
//		service.saveEmployee(new Employee());
		model.addAttribute("employee",new Employee());
		return "add-employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showUpdateForm/{id}")
		public String showUpdateForm(@PathVariable Long id,Model model)
		{
			model.addAttribute("employee",service.getEmployee(id));
			return "edit";
		}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		service.deleteEmployee(id);
		return "redirect:/";
	}
	

}
