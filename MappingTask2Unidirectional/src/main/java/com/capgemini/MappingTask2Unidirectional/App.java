package com.capgemini.MappingTask2Unidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");

        User user1 = new User("Manideep", "manideep@gmail.com");
        User user2 = new User("Ravi", "ravi@gmail.com");

        user1.getRoles().add(role1);
        user1.getRoles().add(role2);

        user2.getRoles().add(role2);

        em.persist(user1);
        em.persist(user2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}