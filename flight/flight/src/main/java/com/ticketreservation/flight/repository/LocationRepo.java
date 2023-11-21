package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Integer> {
    Location findById(int locationId);

}

