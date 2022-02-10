package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.Purchase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Optional finAllByCustomerId(Integer id, Pageable pageable);
}
