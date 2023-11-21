package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirlineRepo extends JpaRepository<Airline,Integer> {

    Airline findById(int airlineId);
}
