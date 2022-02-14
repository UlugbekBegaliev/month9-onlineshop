package com.begaliev.month9onlineshop.repository;

import com.begaliev.month9onlineshop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {


}
