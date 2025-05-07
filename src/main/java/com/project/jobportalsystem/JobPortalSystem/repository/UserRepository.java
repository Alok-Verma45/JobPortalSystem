package com.project.jobportalsystem.JobPortalSystem.repository;

import com.project.jobportalsystem.JobPortalSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); // <-- Add this method
}
