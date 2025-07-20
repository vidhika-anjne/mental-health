package com.mentalwellness.mental_journal.repository;

import com.mentalwellness.mental_journal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); // Optional: to avoid duplicate users
    User findByEmail(String email);      // For login/search (optional)
}
