package com.example.frealsb.Modules.Location.Service;

import com.example.frealsb.Modules.Location.Model.Location;
import com.example.frealsb.Modules.Location.LocationRepository;
import com.example.frealsb.Util.Model.PaginationDTO;
import com.example.frealsb.Util.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private PaginationService paginationService;

    @Override
    public List<Location> getAll(PaginationDTO paginationDTO) {
        Pageable pageable = paginationService.getPageable(paginationDTO);
        return locationRepository.findAll(pageable).toList();
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

    @Override
    public boolean existsByCityAndProvinceAndFeatures(Location location) {
        return locationRepository.existsByCityAndProvinceAndFeatures(location.getCity(), location.getProvince(), location.getFeatures());
    }
}
