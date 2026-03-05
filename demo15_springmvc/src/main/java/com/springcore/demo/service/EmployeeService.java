package com.springcore.demo.service;


import org.springframework.stereotype.Service;
import java.util.*;

import com.springcore.demo.repository.EmployeeRepository;
import com.springcore.demo.model.Employee;

@Service
public class EmployeeService {
	public EmployeeRepository empRepository;
	
	public EmployeeService(EmployeeRepository empRepository) {
		this.empRepository=empRepository;
	}
	
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
	}
	
	public void saveEmployee(Employee employee) {
		empRepository.save(employee);
	}
	
    public Employee getEmployeeById(Long id) {
        return empRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        empRepository.deleteById(id);
    }
	
}
