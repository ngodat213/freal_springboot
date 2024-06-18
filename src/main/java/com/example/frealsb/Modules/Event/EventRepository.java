package com.example.frealsb.Modules.Event;

import com.example.frealsb.Modules.Event.Model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAllBy(String s, Pageable pageable);
}