package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Airline;
import com.ticketreservation.flight.repository.IAirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements IAirlineService {
    private final IAirlineRepo iAirlineRepo;
    @Autowired
    public AirlineServiceImpl(IAirlineRepo iAirlineRepo) {
        this.iAirlineRepo = iAirlineRepo;
    }
    @Override
    public Airline createAirlineDetails(Airline airline1) {
        return iAirlineRepo.save(airline1);
    }@Override
    public List<Airline> getAllAirline() {
        return iAirlineRepo.findAll();
    }
}

