package com.example.frealsb.Modules.Food;

import com.example.frealsb.Modules.Food.Model.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    List<Food> findAllBy(String s, Pageable pageable);
}
