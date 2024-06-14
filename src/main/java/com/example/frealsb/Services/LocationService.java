package com.example.frealsb.Services;

import com.example.frealsb.Entities.Location;
import com.example.frealsb.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocation(String city, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return locationRepository.findAllBy(city, pageable);
    }

    public Location getLocationById(String id) {
        return locationRepository.findById(id).get();
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(String id) {
        locationRepository.deleteById(id);
    }
}
