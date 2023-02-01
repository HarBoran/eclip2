package com.code.bootexample.thymeleafexample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.bootexample.thymeleafexample.DAO.EmployeeRepository;
import com.code.bootexample.thymeleafexample.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
		//return employeeRepository.findAllByOrderByLastNameAsc();
	}
}
