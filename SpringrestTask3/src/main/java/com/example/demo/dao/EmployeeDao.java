package com.example.demo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDao {
	public List<Employee> getEmployeeDetails(){
		List<Employee> employeeList = Arrays.asList(
				new Employee(101,"sohail1",80000),
				new Employee(102,"sohail2",60000),
				new Employee(103,"sohail3",90000),
				new Employee(104,"sohail4",20000),
				new Employee(105,"sohail5",30000)
				);
		return employeeList;
	}
}
