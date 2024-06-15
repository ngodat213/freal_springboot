package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILocationService {
    public List<Location> getAllLocation(String city, int page, int size);

    public Location getLocationById(String id);

    public Location saveLocation(Location location);

    public void deleteLocation(String id);
}
