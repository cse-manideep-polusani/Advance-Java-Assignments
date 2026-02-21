package com.capgemini.MappingTask2Bidirectional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Author a1 = new Author("Chetan Bhagat");
        Author a2 = new Author("J K Rowling");

        Book b1 = new Book("Fiction World");
        Book b2 = new Book("Magic Stories");

        b1.getAuthors().add(a1);
        b1.getAuthors().add(a2);
        a1.getBooks().add(b1);
        a2.getBooks().add(b1);

        b2.getAuthors().add(a2);
        a2.getBooks().add(b2);

        em.persist(b1);
        em.persist(b2);

        em.getTransaction().commit();

        Author author = em.find(Author.class, a2.getAuthorId());
        System.out.println("Books written by " + author.getAuthorName());
        for (Book book : author.getBooks()) {
            System.out.println(book.getTitle());
        }

        Book book = em.find(Book.class, b1.getBookId());
        System.out.println("Authors of book: " + book.getTitle());
        for (Author auth : book.getAuthors()) {
            System.out.println(auth.getAuthorName());
        }

        em.close();
        emf.close();
    }
}