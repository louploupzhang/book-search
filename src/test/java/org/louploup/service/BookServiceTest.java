package org.louploup.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.louploup.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSearchBooksWhenTermIsEmpty() {
        String searchTerm = ""; // Empty search term
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm);
        }, "Expected IllegalArgumentException for empty search term");
    }

    @Test
    void testSearchBooksWhenTermIsNull() {
        String searchTerm = null; // Null search term
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm);
        }, "Expected IllegalArgumentException for null search term");
    }

    @Test
    void testSearchBooksWhenTermIsBlank() {
        String searchTerm = "   "; // Blank search term
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm);
        }, "Expected IllegalArgumentException for blank search term");
    }

    @Test
    void testSearchBooksWhenTermIsValid() {
        String searchTerm = "algorithm"; // Valid search term
        List<Book> books = bookService.searchBooks(searchTerm);
        assertTrue(books.size() > 0, "Expected to find books related to 'algorithm'");
    }
}
