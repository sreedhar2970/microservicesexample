package com.programmingtechie.employeeservice.EmployeeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmingtechie.employeeservice.EmployeeService.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
		

}
