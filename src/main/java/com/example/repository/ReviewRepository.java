package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;
import com.example.entity.Reviewview;

@Repository
public interface ReviewRepository extends JpaRepository<Reviewview, Long> {

    List<Reviewview> findByIdIgnoreCaseContainingOrderByNoDesc(String id,Pageable pageable);

    long countByNoContaining(String id);

    void save(Review obj);
}
