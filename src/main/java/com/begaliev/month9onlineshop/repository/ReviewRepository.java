package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAllByProductId(Integer id);
}
