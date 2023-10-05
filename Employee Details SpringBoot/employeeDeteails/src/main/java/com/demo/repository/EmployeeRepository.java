package com.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);
	
	

}
