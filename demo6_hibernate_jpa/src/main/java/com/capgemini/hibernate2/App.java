package com.capgemini.hibernate2;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // CREATE (INSERT)
            Customer newCustomer =
                    new Customer(108, "John Johnson", "Chicago");

            em.persist(newCustomer);

            // READ (FIND)
            Customer foundCustomer =
                    em.find(Customer.class, 107);

            System.out.println("Found Customer: " + foundCustomer);

            // UPDATE
            if (foundCustomer != null) {
                foundCustomer.setName("Alice Updated");
                foundCustomer.setCity("Seattle");

                em.merge(foundCustomer);

                System.out.println("Updated Customer: " + foundCustomer);
            }

            // DELETE
            Customer customerToDelete =
                    em.find(Customer.class, 101);

            if (customerToDelete != null) {
                em.remove(customerToDelete);
                System.out.println("Deleted Customer: " + customerToDelete);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}

