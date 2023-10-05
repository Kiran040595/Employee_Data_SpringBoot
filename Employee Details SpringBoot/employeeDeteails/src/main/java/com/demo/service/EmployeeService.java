package com.demo.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.custonexception.ProperDataException;
import com.demo.model.Employee;
import com.demo.model.EmployeeRequest;
import com.demo.model.EmployeeResponce;
import com.demo.repository.EmployeeRepository;
import com.demo.specification.EmployeeSpecifications;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<String> getFiledNames() {
		Class<Employee> employeeClass = Employee.class;
		Field[] fields = employeeClass.getDeclaredFields();
		List<String> fieldNames = new ArrayList<>();

		for (Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
	}

	public Employee createEmployee(Employee employee) {
		if (employee.getRole() == null || employee.getEmpAddress() == null || employee.getEmployeeName() == null) {
			throw new ProperDataException();
		}
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(Integer empId) {
		return employeeRepository.findById(empId).get();
	}

	public void deleteById(Integer empId) {
		employeeRepository.deleteById(empId);
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = getEmployeeById(employee.getEmpId());

		if (existingEmployee == null) {
			throw new NoSuchElementException("Employee not found");
		}

		if (employee.getEmployeeName() != null) {
			existingEmployee.setEmployeeName(employee.getEmployeeName());
		}

		if (employee.getRole() != null) {
			existingEmployee.setRole(employee.getRole());
		}

		if (employee.getEmpAddress() != null) {
			existingEmployee.setEmpAddress(employee.getEmpAddress());
		}

		if (employee.getAge() != null) {
			existingEmployee.setAge(employee.getAge());
		}

		return employeeRepository.save(existingEmployee);

	}

	public EmployeeResponce getEmployees(EmployeeRequest request) {

		if (request.getPageSize() <= 0) {
			throw new ProperDataException(HttpStatus.BAD_REQUEST,
					"The Page Size Should Not Be LessThan or Equal To ZERO");
		}

		List<String> validFieldS = getFiledNames();

		if (!validFieldS.contains(request.getSortBy())) {
			throw new ProperDataException(HttpStatus.BAD_REQUEST,
					"The Requested Sort Field Is Not Available In Our Servers");
		}

		Sort sort;
		if ("asc".equalsIgnoreCase(request.getSortOrder())) {
			sort = Sort.by(Sort.Order.asc(request.getSortBy()));
		} else {
			sort = Sort.by(Sort.Order.desc(request.getSortBy()));
		}

		Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), sort);

		Specification<Employee> spec = null;

		for (Employee employee : request.getEmployeeList()) {
			spec = Specification.where(EmployeeSpecifications.filterByName(employee.getEmployeeName()))
					.and(EmployeeSpecifications.filterByAge(employee.getAge()));

		}
		Page<Employee> resultPage = employeeRepository.findAll(spec, pageable);

		if (request.getPage() > resultPage.getTotalPages()) {
			throw new ProperDataException(HttpStatus.BAD_REQUEST, "Requested page exceeds available pages");
		}

		EmployeeResponce responce = new EmployeeResponce();

		if (resultPage.getTotalElements() <= 0) {
			throw new ProperDataException(HttpStatus.BAD_REQUEST, "No records found based on your criteria");
		} else {
			responce.setTotalRecords(resultPage.getTotalElements());
		}

		responce.setCurrentPage(request.getPage());
		responce.setPageSize(request.getPageSize());
		responce.setEmployeeResponces(resultPage.getContent());

		return responce;

	}

}
