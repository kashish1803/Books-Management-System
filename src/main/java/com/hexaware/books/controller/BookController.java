package com.hexaware.books.controller;

import com.hexaware.books.model.Book;
import com.hexaware.books.repository.BookRepository;
import com.hexaware.books.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getAllBooks() {
	    return bookService.getAllBooks();
	}

	@GetMapping("/{isbn}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
	    return bookService.getBookByIsbn(isbn);
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
	    return bookService.addBook(book);
	}

	@PutMapping("/{isbn}")
	public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book updatedBook) {
	    return bookService.updateBook(isbn, updatedBook);
	}

	@DeleteMapping("/{isbn}")
	public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
	    return bookService.deleteBook(isbn);
	}

}

