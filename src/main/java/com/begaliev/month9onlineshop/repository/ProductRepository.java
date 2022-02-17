package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByTypeId(Integer type_id, Pageable pageable);

    Page<Product> findAllByNameContainingOrDescriptionContaining(String name, String description, Pageable pageable);
}
