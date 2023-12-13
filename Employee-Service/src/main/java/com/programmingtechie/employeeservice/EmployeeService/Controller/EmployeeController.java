package com.programmingtechie.employeeservice.EmployeeService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.employeeservice.EmployeeService.Model.Employee;
import com.programmingtechie.employeeservice.EmployeeService.Response.EmployeeResponse;
import com.programmingtechie.employeeservice.EmployeeService.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		
	}
	@PostMapping("/employee")
	public ResponseEntity<Employee> createemployee(@RequestBody Employee employee){
		Employee Nemployee = employeeService.createemployee(employee);
		return new ResponseEntity<>(Nemployee,HttpStatus.CREATED);
		
	}
	

}
