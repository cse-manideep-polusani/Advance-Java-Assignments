package com.techm.bookstore;

import java.util.List;

public class BookManager {
	private BookDao bookDao;

	public BookManager(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}

	public boolean deleteBook(int id) {
		return bookDao.deleteBookById(id);
	}

	public List<Book> processBooks(List<Book> books) {
		String logic = additionalLogic();
		for (Book book : books) {
			if ("Mocked Logic".equals(logic)) {
				book.setPrice(book.getPrice() * 0.8);
			} else {
				book.setPrice(book.getPrice() * 0.9);
			}
		}
		return books;
	}

	public String additionalLogic() {
		return "Real Logic";
	}

	public static double calculateDiscount(double price) {
		return price * 0.9; // 10% discount
	}
}
