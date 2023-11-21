package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Flight;

import java.util.List;

public interface IFlightService {

    public Flight createFlightDetails(Flight fly);

    List<Flight> getAllFlightDetails();
    public List<Flight>getFlightByCities(int src,int dest);
    public boolean doesFlightExist(int fNo);

}

