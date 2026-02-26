package com.capgemini.ManyToMany;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "employee_project",joinColumns = @JoinColumn(name="employee_id"),inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> projects;
	
	public Employee() {
	}

	public Employee(String name, Set<Project> projects) {
		this.name = name;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", projects=" + projects + "]";
	}
	

}
