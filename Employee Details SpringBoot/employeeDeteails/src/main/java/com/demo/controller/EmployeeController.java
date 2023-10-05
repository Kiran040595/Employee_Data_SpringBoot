package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.model.EmployeeRequest;
import com.demo.model.EmployeeResponce;
import com.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@Validated
public class EmployeeController {
	
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping("/requestemployees")
    public  ResponseEntity<EmployeeResponce> getEmployeesByRequest(@RequestBody EmployeeRequest request) {
    	EmployeeResponce employeeResponce= employeeService.getEmployees(request);
    	return ResponseEntity.ok(employeeResponce);
    	}
      
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {    	
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }
    
    @GetMapping ("/{empId}")
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable Integer empId){
    	Employee employeeDemo = employeeService.getEmployeeById(empId); 	
		return ResponseEntity.ok(employeeDemo);	
    }
    
    @DeleteMapping("/{empId}")
    public String deleteEmployeeById(@PathVariable Integer empId) {
    	employeeService.getEmployeeById(empId);
    	employeeService.deleteById(empId);
    	return "Employee "+ empId +" Data deleted Successfully";
    }
    
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }
}
	
	
	


