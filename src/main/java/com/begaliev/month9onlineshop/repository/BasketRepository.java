package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    List<Basket> findAllByCustomerId(Integer id);
}
