package com.capgemini.OneToManyUnidirectional;

import jakarta.persistence.*;
import java.util.*;

public class App {
	public static void main(String[] args) {
		// CREATE Entity Manager factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		// CREATE Entity Manager
		EntityManager em = emf.createEntityManager();
		try {
			// Begin Transaction
			em.getTransaction().begin();
			// CREATE Accounts
			Account acc1 = new Account("ACC12345","Savings");
			Account acc2 = new Account("ACC67890","Bussiness");
			// CREATE Customer and associate accounts
			Customer customer1 = new Customer("John", Arrays.asList(acc1, acc2));
			em.persist(customer1);

			// CREATE Accounts
			Account acc3 = new Account("ACC12346","Current");
			Account acc4 = new Account("ACC67891","Savings");
			// CREATE Customer and associate accounts
			Customer customer2 = new Customer("Mark", Arrays.asList(acc3, acc4));
			em.persist(customer2);

			// CREATE Accounts
			Account acc5 = new Account("ACC12347","Current");
			Account acc6 = new Account("ACC67892","Bussiness");
			// CREATE Customer and associate accounts
			Customer customer3 = new Customer("Miller", Arrays.asList(acc5, acc6));
			em.persist(customer3);

			// READ

			Customer foundCustomer = em.find(Customer.class, 2);
			System.out.println("Found Customer: " + foundCustomer);

//			// UPDATE
//			if (foundCustomer != null) {
//				Account newAccount = new Account("ACC278");
//				foundCustomer.setAccounts(newAccount);
//
//				em.merge(foundCustomer);
//
//				System.out.println("Updated Customer: " + foundCustomer);
//			}

			// DELETE
			Customer customerToDelete = em.find(Customer.class, 5);
			if (customerToDelete != null) {
				em.remove(customerToDelete);
				System.out.println("Deleted Customer : " + customerToDelete);
			} else {
				System.out.println("Customer not found");
			}

			em.getTransaction().commit();

			System.out.println("Customer and Account saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}