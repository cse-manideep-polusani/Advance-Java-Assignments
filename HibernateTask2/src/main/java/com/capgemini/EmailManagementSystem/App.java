package com.capgemini.EmailManagementSystem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        // Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        try {

            // Create User object
            User user = new User();
            user.setUsername("John");

            // Create Set of emails
            Set<String> emails = new HashSet<>();
            emails.add("john@gmail.com");
            emails.add("john.work@gmail.com");
            emails.add("john@gmail.com"); // duplicate - Set avoids it

            user.setEmails(emails);

            // Begin Transaction
            em.getTransaction().begin();

            // Persist user
            em.persist(user);

            // Commit Transaction
            em.getTransaction().commit();

            System.out.println("User saved successfully!");

            // Fetch user
            User fetchedUser = em.find(User.class, user.getUserId());

            System.out.println("User Name: " + fetchedUser.getUsername());
            System.out.println("Emails: " + fetchedUser.getEmails());

        } finally {
            em.close();
            emf.close();
        }
    }
}
