package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    List<Location> findAllBy(String city, Pageable pageable);
}
