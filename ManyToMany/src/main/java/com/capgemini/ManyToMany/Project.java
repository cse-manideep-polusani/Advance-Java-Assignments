package com.capgemini.ManyToMany;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String projectName;
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees;
	
	public Project() {
		
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public int getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", employees=" + employees + "]";
	}
}
