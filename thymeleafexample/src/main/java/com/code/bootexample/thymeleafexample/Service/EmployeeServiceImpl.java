package com.code.bootexample.thymeleafexample.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.bootexample.thymeleafexample.DAO.EmployeeRepository;
import com.code.bootexample.thymeleafexample.entity.Employee;


//Autowired는 필드 주입, 생성자 주입, Setter 주입 3가지가 있음. 보통은 생성자 주입을 많이 씀
//이 부분이 생성자 주입. 바로 위에 있는 private 부분에 Autowired를 쓰면 필드 주입.
//여기서 생성자 주입을 하는 이유는 DAO 즉, EmployeeRepository에서 빈 등록이 된 애를 여기서 쓸 수 있게 주입하기 위해. 기본 생성자 public EmployeeServiceImpl() {}이 아닌 
//아래와 같은 형태에서는 EmployeeRepository에 값을 넣어주기 위해 끌어와야 하므로, 의존성 주입이 필요함.
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired //여기서는 없어도 작동함. 가독성때문이라도 있는게 좋음
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
		//return employeeRepository.findAllByOrderByLastNameAsc();
	}
	
	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new NoSuchElementException("Not id like" + id);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}

}
