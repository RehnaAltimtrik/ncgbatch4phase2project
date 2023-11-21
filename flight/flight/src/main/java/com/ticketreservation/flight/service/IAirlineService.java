package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Airline;

import java.util.List;

public interface IAirlineService {
    public Airline createAirlineDetails(Airline airline1);

    public List<Airline> getAllAirline();
}

