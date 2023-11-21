package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlightRepo extends JpaRepository<Flight,Integer> {
    List<Flight> findBySource_LocationIdAndDestination_LocationId(String src, String dest);
    Flight findById(int flightNo);

}
