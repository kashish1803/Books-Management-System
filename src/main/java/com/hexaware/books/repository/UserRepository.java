package com.hexaware.books.repository;

import com.hexaware.books.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by username (used during login for JWT)
    User findByUsername(String username);
}
