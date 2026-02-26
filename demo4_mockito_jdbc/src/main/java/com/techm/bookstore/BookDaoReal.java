package com.techm.bookstore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoReal {

    // Database connection details
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all books from the database
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Add a book to the database
    public boolean addBook(Book book) {
        String query = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a book from the database by ID
    public boolean deleteBookById(int id) {
        String query = "DELETE FROM books WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔹 MAIN METHOD (Driver Code)
    public static void main(String[] args) {

        BookDaoReal dao = new BookDaoReal();

        // Insert data
        Book book1 = new Book(0, "Java Fundamentals", "James Gosling", 550);
        Book book2 = new Book(0, "Spring Boot", "Pivotal", 750);

        System.out.println("Insert Book 1: " + dao.addBook(book1));
        System.out.println("Insert Book 2: " + dao.addBook(book2));

        // Fetch all books
        System.out.println("\nBooks in DB:");
        List<Book> books = dao.getAllBooks();
        books.forEach(System.out::println);

        // Delete book by ID (change ID if needed)
        System.out.println("\nDelete Book with ID 1: " + dao.deleteBookById(1));

        // Fetch again
        System.out.println("\nBooks after deletion:");
        dao.getAllBooks().forEach(System.out::println);
    }
}
