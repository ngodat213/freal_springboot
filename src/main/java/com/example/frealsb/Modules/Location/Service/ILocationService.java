package com.example.frealsb.Modules.Location.Service;

import com.example.frealsb.Modules.Location.Model.Location;

import java.util.List;

public interface ILocationService {
    List<Location> getAllLocation(String city, int page, int size);
    Location getLocationById(String id);
    Location saveLocation(Location location);
    Location deleteLocation(String id);
}
