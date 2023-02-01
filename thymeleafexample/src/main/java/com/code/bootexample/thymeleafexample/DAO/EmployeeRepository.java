package com.code.bootexample.thymeleafexample.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.bootexample.thymeleafexample.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAll();
	
}
