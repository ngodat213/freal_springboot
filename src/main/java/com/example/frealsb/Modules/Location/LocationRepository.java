package com.example.frealsb.Modules.Location;

import com.example.frealsb.Modules.Location.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    List<Location> findAllBy(String s, Pageable pageable);
    boolean existsByCityAndProvinceAndFeatures(String city, String province, String features);
}
