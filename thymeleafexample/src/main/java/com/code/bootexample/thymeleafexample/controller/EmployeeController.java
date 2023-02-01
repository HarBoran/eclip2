package com.code.bootexample.thymeleafexample.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.bootexample.thymeleafexample.Service.EmployeeService;
import com.code.bootexample.thymeleafexample.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private List<Employee> employees;
	
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
//	}
		employees = employeeService.findAll();
	}
	
	@GetMapping("/list")
	private String GetEmployees(Model theModel) {
		theModel.addAttribute("employees", employees);
		return "list-employees";
	}
	
}
