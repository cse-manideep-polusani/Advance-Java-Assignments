package com.techm.bookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class BookManagerTest {

	private BookDao bookDao; // Mocked DAO
	private BookManager bookManager; // BookManager to test

	@BeforeEach
	void setUp() {
		bookDao = mock(BookDao.class);// Manually create a mock object for BookDao
		bookManager = new BookManager(bookDao);// Initialize BookManager with the mocked DAO
	}

	@Test
	void testGetAllBooks() {
		// Arrange: Define mock behavior
		List<Book> mockBooks = Arrays.asList(new Book(1, "Effective Java", "Joshua Bloch", 45.50),
				new Book(2, "Clean Code", "Robert C. Martin", 40.00));
		when(bookDao.getAllBooks()).thenReturn(mockBooks);

		// Act: Call the method
		List<Book> books = bookManager.getAllBooks();

		// Assert: Verify the results
		assertNotNull(books);
		assertEquals(2, books.size());
		assertEquals("Effective Java", books.get(0).getTitle());
		verify(bookDao, times(1)).getAllBooks(); // Verify that the DAO method was called once
	}

	@Test
	void testAddBook() {
		// Arrange: Define mock behavior
		Book book = new Book(1, "Effective Java", "Joshua Bloch", 45.50);
		when(bookDao.addBook(book)).thenReturn(true);

		// Act: Call the method
		boolean result = bookManager.addBook(book);

		// Assert: Verify the results
		assertTrue(result);
		verify(bookDao, times(1)).addBook(book); // Verify that the DAO method was called once
	}

	@Test
	void testDeleteBook() {
		// Arrange: Define mock behavior
		int bookId = 1;
//		when(bookDao.deleteBookById(bookId)).thenReturn(true);
		when(bookDao.deleteBookById(anyInt())).thenReturn(true);
		// Act: Call the method
		boolean result = bookManager.deleteBook(anyInt());

		// Assert: Verify the results
		assertTrue(result);
		verify(bookDao, times(1)).deleteBookById(anyInt()); // Verify that the DAO method was called once
	}
}