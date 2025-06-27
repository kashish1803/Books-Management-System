package com.hexaware.books.service;

import com.hexaware.books.model.Book;
import com.hexaware.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        return book.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Book> addBook(Book book) {
        if (bookRepository.existsById(book.getIsbn())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    public ResponseEntity<Book> updateBook(String isbn, Book updatedBook) {
        return bookRepository.findById(isbn).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPublicationYear(updatedBook.getPublicationYear());
            return ResponseEntity.ok(bookRepository.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> deleteBook(String isbn) {
        if (bookRepository.existsById(isbn)) {
            bookRepository.deleteById(isbn);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

