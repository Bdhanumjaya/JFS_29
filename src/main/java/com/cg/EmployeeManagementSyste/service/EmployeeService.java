package com.cg.EmployeeManagementSyste.service;



import java.util.List;

import com.cg.EmployeeManagementSyste.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee emp);
	
	public Employee getEmployee(Long id);
	
	public Employee updateEmployee(Employee emp,Long id);
	
	public void deleteEmployee(Long id);
	
	public List<Employee> getAllEmployees();

}
