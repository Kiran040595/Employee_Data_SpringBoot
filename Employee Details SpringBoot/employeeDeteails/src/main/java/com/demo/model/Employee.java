package com.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	
	@NotEmpty(message = "is Required")
	private String employeeName;
	private String role;
	private String empAddress;
	@Min(value=18, message="Value Should Be GraterThan 18")
	private Integer age;
	
	public Employee() {

	}

	public Employee(int empId, @NotEmpty(message = "Employee Name is Required") String employeeName, String role,
			String empAddress, @Min(value = 18, message = "Age Should Be GraterThan 18") Integer age) {
		
		this.empId = empId;
		this.employeeName = employeeName;
		this.role = role;
		this.empAddress = empAddress;
		this.age = age;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "EmployeeDemo [empId=" + empId + ", employeeName=" + employeeName + ", role=" + role + ", empAddress="
				+ empAddress + ", age=" + age + "]";
	}	

}
