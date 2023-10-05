package com.demo.model;

import java.util.List;

public class EmployeeRequest {
	
	
	private int page=0;
	private int pageSize=10;
	private String sortBy="employeeName"; 
	private String sortOrder;
    private List<Employee> employeeList;
	
	
	
	



	public EmployeeRequest(int page, int pageSize, String sortBy, String sortOrder, List<Employee> employeeList) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.sortBy = sortBy;
		this.sortOrder = sortOrder;
		this.employeeList = employeeList;
	}







	public int getPage() {
		return page;
	}







	public void setPage(int page) {
		this.page = page;
	}







	public int getPageSize() {
		return pageSize;
	}







	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}







	public String getSortBy() {
		return sortBy;
	}







	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}







	public String getSortOrder() {
		return sortOrder;
	}







	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}







	public List<Employee> getEmployeeList() {
		return employeeList;
	}







	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	
	
	

}



