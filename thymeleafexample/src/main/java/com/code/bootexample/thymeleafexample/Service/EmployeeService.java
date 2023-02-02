package com.code.bootexample.thymeleafexample.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.bootexample.thymeleafexample.entity.Employee;
	
public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int id);

	public void save(Employee employee);

	public void delete(Employee employee);


}
