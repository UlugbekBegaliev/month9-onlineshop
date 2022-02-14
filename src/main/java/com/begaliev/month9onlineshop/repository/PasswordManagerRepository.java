package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.PasswordManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordManagerRepository extends JpaRepository<PasswordManager, Integer> {


    boolean existsByToken(String token);
}
