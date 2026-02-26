package com.techm.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public List<Book> getAllBooks() {
        // Simulate database interaction
        return new ArrayList<>();
    }

    public boolean addBook(Book book) {
        // Simulate adding book to the database
        return true;
    }

    public boolean deleteBookById(int id) {
        // Simulate deleting book from the database
        return true;
    }

    //final method
    public final String getDatabaseInfo() {
        return "Connected to DB";
    }
    //void method
    public void logAction(String action) {
        // Simulate logging action
    }
}
