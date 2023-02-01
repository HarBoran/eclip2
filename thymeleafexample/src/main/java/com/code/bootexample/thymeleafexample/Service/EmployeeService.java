package com.code.bootexample.thymeleafexample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.bootexample.thymeleafexample.entity.Employee;
	
public interface EmployeeService {
	public List<Employee> findAll();
	
}
