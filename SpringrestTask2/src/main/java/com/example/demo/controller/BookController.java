package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/author")
    public ResponseEntity<?> getByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(bookService.getByAuthor(author));
    }

    @GetMapping("/genre")
    public ResponseEntity<?> getByGenre(@RequestParam String genre) {
        return ResponseEntity.ok(bookService.getByGenre(genre));
    }


    @GetMapping("/cheaper")
    public ResponseEntity<?> getCheaper(@RequestParam double maxPrice) {
        return ResponseEntity.ok(bookService.getCheaper(maxPrice));
    }

    @GetMapping("/expensive")
    public ResponseEntity<?> getExpensive(@RequestParam double minPrice) {
        return ResponseEntity.ok(bookService.getExpensive(minPrice));
    }

    @GetMapping("/new-arrivals")
    public ResponseEntity<?> getNewArrivals(@RequestParam LocalDate publishedAfter) {
        return ResponseEntity.ok(bookService.getPublishedAfter(publishedAfter));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        return ResponseEntity.ok(bookService.searchTitle(keyword));
    }

    @GetMapping("/genre-author")
    public ResponseEntity<?> getByGenreAndAuthor(
            @RequestParam String genre,
            @RequestParam String author) {
        return ResponseEntity.ok(bookService.getByGenreAndAuthor(genre, author));
    }
    @GetMapping("/genre-or-author")
    public ResponseEntity<?> getByGenreOrAuthor(
            @RequestParam String genre,
            @RequestParam String author) {
        return ResponseEntity.ok(bookService.getByGenreAndAuthor(genre, author));
    }
    @GetMapping("/price-range")
    public ResponseEntity<?> getByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {
        return ResponseEntity.ok(bookService.getByPriceRange(minPrice, maxPrice));
    }
    @GetMapping("/genre-discount")
    public ResponseEntity<?> getByGenreAndMaxPrice(
            @RequestParam String genre,
            @RequestParam String maxPrice) {
        return ResponseEntity.ok(bookService.getByGenreAndAuthor(genre, maxPrice));
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatest(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(bookService.getLatestBooks(page, size));
    }

    @GetMapping("/by-price")
    public ResponseEntity<?> getByPrice(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(bookService.getBooksByPrice(page, size));
    }
}