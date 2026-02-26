package com.techm.bookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class BookManagerTestWithAnnotations {

	// Mock the BookDao dependency to avoid real database interaction
	@Mock
	private BookDao bookDao;

	// Inject the mocked BookDao into BookManager
	@InjectMocks
	private BookManager bookManager;

	@BeforeEach
	void setUp() {
		// Initialize Mockito annotations before each test
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test to verify the behavior of getAllBooks method. This method should return
	 * the mocked list of books.
	 */
	@Test
	void testGetAllBooks() {
		// Arrange: Define mock behavior
		List<Book> mockBooks = Arrays.asList(new Book(1, "Effective Java", "Joshua Bloch", 45.50),
				new Book(2, "Clean Code", "Robert C. Martin", 40.00));
		when(bookDao.getAllBooks()).thenReturn(mockBooks);

		// Act: Call the method to be tested
		List<Book> books = bookManager.getAllBooks();

		// Assert: Verify the results
		assertNotNull(books);
		assertEquals(2, books.size());
		assertEquals("Effective Java", books.get(0).getTitle());

		// Verify that the getAllBooks method was called exactly once
		verify(bookDao, times(1)).getAllBooks();
	}

	/**
	 * Test to verify the behavior of addBook method. This method should return true
	 * if the book is added successfully.
	 */
	@Test
	void testAddBook() {
		// Arrange: Define mock behavior
		Book book = new Book(1, "Effective Java", "Joshua Bloch", 45.50);
		when(bookDao.addBook(book)).thenReturn(true);

		// Act: Call the method to be tested
		boolean result = bookManager.addBook(book);

		// Assert: Verify the results
		assertTrue(result);
		// Verify that the addBook method was called exactly once
		verify(bookDao, times(1)).addBook(book);
	}

	/**
	 * Test to verify the behavior of deleteBook method. This method should return
	 * true if the book is deleted successfully.
	 */
	@Test
	void testDeleteBook() {
		// Arrange: Define mock behavior
		int bookId = 1;
		when(bookDao.deleteBookById(bookId)).thenReturn(true);

		// Act: Call the method to be tested
		boolean result = bookManager.deleteBook(bookId);

		// Assert: Verify the results
		assertTrue(result);
		// Verify that the deleteBookById method was called exactly once
		verify(bookDao, times(1)).deleteBookById(bookId);
	}

	/**
	 * Test to verify the behavior of the (static method) calculateDiscount. This
	 * method should apply a 10% discount to the price.
	 */
	@Test
	void testCalculateDiscount() {
		// Mock the static method of BookUtils
		MockedStatic<BookManager> mockedStatic = mockStatic(BookManager.class);
		// Arrange: Define mock behavior for static method
		mockedStatic.when(() -> BookManager.calculateDiscount(100.0)).thenReturn(80.0);

		// Act: Call the static method
		double discount = BookManager.calculateDiscount(100.0);

		// Assert: Verify the results
		assertEquals(80.0, discount);
		// Verify that the static method was called exactly once
		mockedStatic.verify(() -> BookManager.calculateDiscount(100.0), times(1));
	}

	/**
	 * Test to verify the behavior of getDatabaseInfo method (final method). This
	 * method should return the mocked database connection information.
	 */
	@Test
	void testGetDatabaseInfo() {
		// Arrange: Define mock behavior
		when(bookDao.getDatabaseInfo()).thenReturn("Mocked DB Info");

		// Act: Call the method
		String dbInfo = bookDao.getDatabaseInfo();

		// Assert: Verify the results
		assertEquals("Mocked DB Info", dbInfo);
		// Verify that the getDatabaseInfo method was called exactly once
		verify(bookDao, times(1)).getDatabaseInfo();
	}

	/**
	 * Test to verify the behavior of logAction method (void method). This method
	 * should perform the logging action without returning a value.
	 */
	@Test
	void testLogAction() {
		// Arrange: Define mock behavior for the void method
		doNothing().when(bookDao).logAction("Save");

		// Act: Call the void method
		bookDao.logAction("Save");

		// Assert: Verify the behavior
		verify(bookDao, times(1)).logAction("Save");
	}

	/**
	 * Test to verify the behavior of processBooks method (using a spy). The spy
	 * allows us to mock only specific methods while using real logic for others.
	 */
	@Test
	void testProcessBooksWithSpy() {
		// Create a spy instance of BookManager to mock only some methods
		BookManager spyManager = spy(new BookManager(bookDao));
		List<Book> books = Arrays.asList(new Book(1, "Java", "Author", 100.0));

		// Arrange: Mock only the additionalLogic method using spy
		doReturn("Mocked Logic").when(spyManager).additionalLogic();

		// Act: Call the method that processes books
		List<Book> processedBooks = spyManager.processBooks(books);

		// Assert: Verify the results
		assertEquals(80.0, processedBooks.get(0).getPrice());
		assertEquals("Mocked Logic", spyManager.additionalLogic());
		// Verify that the additionalLogic method was called exactly once
		verify(spyManager, times(2)).additionalLogic();
	}
}
