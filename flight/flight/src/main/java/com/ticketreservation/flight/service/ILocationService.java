package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Location;

import java.util.List;

public interface ILocationService {

    public Location createLocation(Location loc);

    public List<Location> getAllLocation();

    public Location getLocationByID(int locationId);

}
