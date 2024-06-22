package com.example.frealsb.Modules.Location.Service;

import com.example.frealsb.Modules.Location.Model.Location;
import com.example.frealsb.Util.Model.PaginationDTO;

import java.util.List;

public interface ILocationService {
    // __CURD__ //
    List<Location> getAll(PaginationDTO paginationDTO);
    Location getLocationById(String id);
    Location saveLocation(Location location);
    Location deleteLocation(String id);
    //
    boolean existsByCityAndProvinceAndFeatures(Location location);
}
