package com.capgemini.LibraryBookInventoryManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List; 

public class LibraryBookJpaApp {
    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // CREATE (INSERT)
            Book newBook =
                    new Book(108, "Fire Boult","Manideep", "Love War", 499.99, "Available",2019);
            Book newBook1 =
                    new Book(109, "Ramp","Radha", "Love Drama", 299.99, "Available",2017);
            Book newBook2 =
                    new Book(110, "Hero","Rahul", "Suspense Thriller", 699.99, "Issued",2015);

            em.persist(newBook);
            em.persist(newBook1);
            em.persist(newBook2);

            // READ (FIND)
            Book bookFound =
                    em.find(Book.class, 110);

            System.out.println("Found Book: " + bookFound);
            

            // READ (FETCH ALL BOOKS)  // ADDED
            TypedQuery<Book> query =
                    em.createQuery("SELECT b FROM Book b", Book.class);
            List<Book> books = query.getResultList();

            System.out.println("\nAll Books:");
            for (Book b : books) {
                System.out.println(b);
            }


            // UPDATE
            if (bookFound != null) {
            	bookFound.setPrice(700.0);
            	bookFound.setAvailabilityStatus("Available");

                em.merge(bookFound);

                System.out.println("Updated Book: " + bookFound);
            }

            // DELETE
            Book deleteBook =
                    em.find(Book.class, 101);

            if (deleteBook != null) {
                em.remove(deleteBook);
                System.out.println("Deleted Book: " + deleteBook);
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


