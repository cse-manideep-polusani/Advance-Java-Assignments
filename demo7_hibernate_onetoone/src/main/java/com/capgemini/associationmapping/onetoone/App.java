package com.capgemini.associationmapping.onetoone;

/**
 * Hello world!
 *
 */
import jakarta.persistence.*;

public class App {

	public static void main(String[] args) {

		// Create EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

		// Create EntityManager
		EntityManager em = emf.createEntityManager();

		// Begin Transaction
		em.getTransaction().begin();
		// Create User objects
		Account account = new Account("ACC12345", "Savings");
		Customer customer = new Customer("Manideep", account);

		// set bidirectional relationship
		account.setCustomer(customer);
		// Persist customer (account will also persist if cascade is used)
		em.persist(customer);
		// commit Transaction
		em.getTransaction().commit();

		System.out.println("Customer and Account saved successfully!");
	}
}
