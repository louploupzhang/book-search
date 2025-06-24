package org.louploup.service;

import java.util.List;

import org.louploup.entity.Book;
import org.louploup.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term must not be null or empty");
        }
        return bookRepository.searchBooks(searchTerm);
    }
}
