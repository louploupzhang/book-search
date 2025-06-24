package org.louploup.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.louploup.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSearchBooks() {
        List<Book> books = bookRepository.searchBooks("algorithm");
        assertTrue(books.size() > 0, "Expected to find books related to 'algorithm'");
        for (Book book : books) {
            System.out.println(">>> Found book: " + book.getTitle() + " with ID: " + book.getBookId());
        }
    }
}
