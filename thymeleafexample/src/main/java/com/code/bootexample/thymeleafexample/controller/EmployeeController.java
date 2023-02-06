package com.code.bootexample.thymeleafexample.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.bootexample.thymeleafexample.Service.EmployeeService;
import com.code.bootexample.thymeleafexample.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	

	@Autowired
	private EmployeeService employeeService;
	
//	Autowired의 일부분과 동일한 기능, 여기에서는 동일한 기능,  @Autowired는 다른 방식으로 작동하는 기능도 있음
//	public EmployeeController(EmployeeService theEmployeeService) {
//		employeeService = theEmployeeService;
//	}

	@PostConstruct
	private void loadData() {
//		Employee tempEmployee1 = new Employee(1, "Mark", "Writer", "mark@email.com");
//		Employee tempEmployee2 = new Employee(2, "Matthew", "TaxCollector", "mat@email.com");
//		Employee tempEmployee3 = new Employee(3, "Daniel", "Bold", "dan@email.com");
//		
//		employees = new ArrayList<>();
//		
//		employees.add(tempEmployee1);
//		employees.add(tempEmployee2);
//		employees.add(tempEmployee3);
	}
	
	@GetMapping("/list")
	private String GetEmployees(Model theModel) {
		List<Employee> theEmployees= employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	private String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
//	@GetMapping("/showFormForUpdate")
//	@PostMapping("/showFormForUpdate")
	@RequestMapping(value="/showFormForUpdate" , method = {RequestMethod.GET, RequestMethod.POST})
	private String update(@RequestParam("id") int id, Model theModel) {
		Employee employee = employeeService.findById(id);
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	private String save(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}
	
	//@GetMapping("/delete")
	@RequestMapping(value="/delete" , method = {RequestMethod.GET, RequestMethod.POST})
	private String delete(@ModelAttribute("employee") Employee employee, @RequestParam(value = "employeeId", defaultValue="0") int theId) {
		employeeService.delete(employee);
		if ((theId != 0)) {
			employeeService.deleteById(theId);
		}
		return "redirect:/";
	}
	
}
