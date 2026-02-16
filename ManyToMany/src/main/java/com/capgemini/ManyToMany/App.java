package com.capgemini.ManyToMany;

import jakarta.persistence.*;
import java.util.*;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			// Create Projects
			Project p1 = new Project("LibraryManagementSystem");
			Project p2 = new Project("UniversityManagementSystem");

			Project p3 = new Project("EcommerceWebsite");
			Project p4 = new Project("RestaurentWebsite");

			// Add Projects
			Set<Project> projectSet = new HashSet<>();
			projectSet.add(p1);
			projectSet.add(p2);

			Set<Project> projectSet1 = new HashSet<>();
			projectSet1.add(p1);
			projectSet1.add(p3);
			projectSet1.add(p4);

			// Create Employees
			Employee e1 = new Employee("Manideep", projectSet);
			Employee e2 = new Employee("Rahul", projectSet1);

			// Add employees
			Set<Employee> employeeSet = new HashSet<>();
			employeeSet.add(e1);
			employeeSet.add(e2);

			// Bidirectional
			// Set employees to projects
			p1.setEmployees(employeeSet);
			p2.setEmployees(employeeSet);

			em.persist(e1);
			em.persist(e2);

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
