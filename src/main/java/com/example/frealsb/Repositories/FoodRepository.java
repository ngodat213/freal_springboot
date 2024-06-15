package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Food;
import com.example.frealsb.Entities.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    List<Food> findAllBy(String s, Pageable pageable);
}
