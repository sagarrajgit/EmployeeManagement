package com.employee.dao;

import com.employee.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);
	public void displayEmployee();
	public void filterEmployee(String record, String value);
	public void searchEmployee(String id);
	public void updateEmployee(String id, String record, String value);
	public void deleteEmployee(String value);
	public void avgDeptSalary(String dept);
	public void avgSalary();
}