package com.example.frealsb.Modules.Location.Service;

import com.example.frealsb.Modules.Location.Model.Location;
import com.example.frealsb.Modules.Location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocation(String city, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return locationRepository.findAllBy(city, pageable);
    }

    @Override
    public Location getLocationById(String id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location deleteLocation(String id) {
        Location location = getLocationById(id);
        location.setDeleted(true);
        return locationRepository.save(location);
    }
}
