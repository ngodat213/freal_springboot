package com.example.frealsb.Modules.FoodCategory;

import com.example.frealsb.Modules.FoodCategory.Model.FoodCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, String> {
    List<FoodCategory> findAllBy(String s, Pageable pageable);
}
