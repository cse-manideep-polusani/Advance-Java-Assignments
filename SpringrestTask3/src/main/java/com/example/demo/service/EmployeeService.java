package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	EmployeeDao employeeDao;
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	public List<Employee> above50k(){
		List<Employee> above50kList = employeeDao.getEmployeeDetails();
		return above50kList.stream().filter((Employee e) -> e.getSalary() > 50000).collect(Collectors.toList());
	}
}
