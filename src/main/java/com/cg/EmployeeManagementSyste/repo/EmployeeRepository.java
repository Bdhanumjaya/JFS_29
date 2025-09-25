package com.cg.EmployeeManagementSyste.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.EmployeeManagementSyste.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
