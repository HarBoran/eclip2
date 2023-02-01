package com.code.bootexample.thymeleafexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.code.bootexample.thymeleafexample.entity.Employee;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String WelcomePage() {
		return "welcomepage";
	}

	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new java.util.Date());

		return "helloworld";
	}

} 
