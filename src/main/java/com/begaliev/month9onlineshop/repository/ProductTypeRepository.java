package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
