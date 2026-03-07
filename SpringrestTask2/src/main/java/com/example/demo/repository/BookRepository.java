package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByPriceLessThan(double maxPrice);

    List<Book> findByPriceGreaterThan(double minPrice);

    List<Book> findByPublishedDateAfter(LocalDate date);

    List<Book> findByTitleContainingIgnoreCase(String keyword);

    List<Book> findByGenreAndAuthor(String genre, String author);

    List<Book> findByGenreOrAuthor(String genre, String author);

    List<Book> findByPriceBetween(double min, double max);

    List<Book> findByGenreAndPriceLessThan(String genre, double maxPrice);

    Page<Book> findAllByOrderByPublishedDateDesc(Pageable pageable);

    Page<Book> findAllByOrderByPriceAsc(Pageable pageable);
}