package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Location;
import com.ticketreservation.flight.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService{

    private final LocationRepo locationRepo;
    @Autowired

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public Location createLocation(Location loc) {
        return locationRepo.save(loc);

    }

    @Override
    public List<Location> getAllLocation() {
        return locationRepo.findAll();
    }

    @Override
    public Location getLocationByID(int locationId) {

        return locationRepo.findById(locationId);
    }
}

