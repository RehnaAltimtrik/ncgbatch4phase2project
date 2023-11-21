package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Flight;
import com.ticketreservation.flight.repository.IAirlineRepo;
import com.ticketreservation.flight.repository.IFlightRepo;
import com.ticketreservation.flight.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {
    private final IFlightRepo flightRepo;

    private final IAirlineRepo airlineRepo;

    private final LocationRepo locationRepo;
    @Autowired

    public FlightServiceImpl(IFlightRepo flightRepo, IAirlineRepo airlineRepo, LocationRepo locationRepo) {
        this.flightRepo = flightRepo;
        this.airlineRepo = airlineRepo;
        this.locationRepo = locationRepo;
    }

    @Override
    public Flight createFlightDetails(Flight fly) {
        fly.setAirline(airlineRepo.findById(fly.getAirId()));
        fly.setSource(locationRepo.findById(fly.getSrc()));
        fly.setDestination(locationRepo.findById(fly.getDest()));

        return flightRepo.save(fly);
    }

    @Override
    public List<Flight> getAllFlightDetails() {
        try{ return flightRepo.findAll();}
        catch (DataAccessException e){
            return Collections.emptyList();
        }
    }

    @Override
    public List<Flight> getFlightByCities(int src, int dest) {
        return flightRepo.findBySource_LocationIdAndDestination_LocationId(Integer.toString(src), Integer.toString(dest));


    }

    @Override
    public boolean doesFlightExist(int fNo) {
        try{
    return flightRepo.existsById(fNo);}
     catch (DataAccessException e){
        return false;
    }
    }




}
