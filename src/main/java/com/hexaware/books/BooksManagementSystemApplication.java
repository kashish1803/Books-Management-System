package com.hexaware.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksManagementSystemApplication.class, args);
		System.out.println("Welcome to Book Management System !!");
	}

}
