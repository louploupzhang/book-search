package org.louploup.controller;

import java.util.List;

import org.louploup.entity.Book;
import org.louploup.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String searchTerm) {
        return bookService.searchBooks(searchTerm);
    }
}
