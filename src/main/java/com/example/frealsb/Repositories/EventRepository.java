package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Event;
import com.example.frealsb.Entities.FoodFeatured;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAllBy(String s, Pageable pageable);
}