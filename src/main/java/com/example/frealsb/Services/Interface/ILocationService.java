package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {
    List<Location> getAllLocation(String city, int page, int size);
    Location getLocationById(String id);
    Location saveLocation(Location location);
    void deleteLocation(String id);
}
