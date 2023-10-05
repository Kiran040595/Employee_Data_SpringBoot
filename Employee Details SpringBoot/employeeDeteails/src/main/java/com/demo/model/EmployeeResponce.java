package com.demo.model;

import java.util.List;

public class EmployeeResponce {

    
    private long totalRecords;
    private Integer currentPage;
    private Integer pageSize;
    private List<Employee> employeeResponces;
             
    



	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
    public List<Employee> getEmployeeResponces() {
        return employeeResponces;
    }

    public void setEmployeeResponces(List<Employee> employeeResponces) {
        this.employeeResponces = employeeResponces;
    }
}
