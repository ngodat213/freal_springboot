package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.FoodFeatured;
import com.example.frealsb.Entities.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodFeaturedRepository extends JpaRepository<FoodFeatured, String> {
    List<FoodFeatured> findAllBy(String s, Pageable pageable);
}
