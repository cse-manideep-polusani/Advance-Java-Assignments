package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    public List<Book> getByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<Book> getCheaper(double maxPrice) {
        return bookRepo.findByPriceLessThan(maxPrice);
    }

    public List<Book> getExpensive(double minPrice) {
        return bookRepo.findByPriceGreaterThan(minPrice);
    }

    public List<Book> getPublishedAfter(LocalDate publishedAfter) {
        return bookRepo.findByPublishedDateAfter(publishedAfter);
    }

    public List<Book> searchTitle(String keyword) {
        return bookRepo.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Book> getByGenreAndAuthor(String genre, String author) {
        return bookRepo.findByGenreAndAuthor(genre, author);
    }

    public List<Book> getByGenreOrAuthor(String genre, String author) {
        return bookRepo.findByGenreOrAuthor(genre, author);
    }

    public List<Book> getByPriceRange(double minPrice, double maxPrice) {
        return bookRepo.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Book> getByGenreAndMaxPrice(String genre, double maxPrice) {
        return bookRepo.findByGenreAndPriceLessThan(genre, maxPrice);
    }

    public Page<Book> getLatestBooks(int page, int size) {
        return bookRepo.findAllByOrderByPublishedDateDesc(PageRequest.of(page, size));
    }

    public Page<Book> getBooksByPrice(int page, int size) {
        return bookRepo.findAllByOrderByPriceAsc(PageRequest.of(page, size));
    }
}