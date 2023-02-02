package com.code.bootexample.thymeleafexample.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.bootexample.thymeleafexample.entity.Employee;

//부트 이전에 스프링 프레임워크에서는 여기서 @Repository 애너테이션을 추가하여 빈을 등록했었지만, 
//부트에서는 아래와 같이 JpaRepository를 상속함으로써 알아서 빈이 등록되어 애너테이션을 추가할 필요가 없음. 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //<엔티티타입, primary key>
	
	//public List<Employee> findAll();
	//public List<Employee> findAllByOrderByLastNameAsc();
	//<S extends Employee> S save(S entity);
	
}
