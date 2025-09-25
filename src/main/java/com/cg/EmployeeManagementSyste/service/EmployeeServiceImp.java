package com.cg.EmployeeManagementSyste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSyste.entity.Employee;
import com.cg.EmployeeManagementSyste.repo.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

	
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp = repo.findById(id).get();
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp, Long id) {
		// TODO Auto-generated method stub
		Employee emp1 = repo.findById(id).get();
		return repo.save(emp1);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
