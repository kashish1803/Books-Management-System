package com.hexaware.books.repository;

import com.hexaware.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // The String here is the type of the primary key (ISBN)
}
