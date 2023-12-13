package com.programmingtechie.employeeservice.EmployeeService.Service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.programmingtechie.employeeservice.EmployeeService.Model.Employee;
import com.programmingtechie.employeeservice.EmployeeService.Repository.EmployeeRepo;
import com.programmingtechie.employeeservice.EmployeeService.Response.AddressResponse;
import com.programmingtechie.employeeservice.EmployeeService.Response.EmployeeResponse;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private WebClient webClient;
	
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
	
	public EmployeeResponse getEmployeeById(int id) {
		
		Employee employee = employeeRepo.findById(id).get();
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
//		ServiceInstance serviceInstance =loadBalancerClient.choose("address-service");
//		String uri = serviceInstance.getUri().toString();
//		System.out.println(uri);
		AddressResponse addressResponse =webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressResponse.class).block();
		employeeResponse.setAddressResponse(addressResponse);
		return employeeResponse;
	}
	
	public Employee createemployee(Employee employee) {
		return employeeRepo.save(employee);	
	}
	
	}

	

