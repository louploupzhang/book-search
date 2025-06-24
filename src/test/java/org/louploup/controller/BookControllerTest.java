package org.louploup.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.louploup.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    void testSearchBooks() {
        String searchTerm = "algorithm"; // Valid search term
        ResponseEntity<Book[]> response = restTemplate.getForEntity("/books/search?searchTerm={searchTerm}", Book[].class, searchTerm);
        Book[] books = response.getBody();
        assertNotNull(books, "Expected non-null response body");
        assertTrue(books.length > 0, "Expected to find books related to 'algorithm'");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
