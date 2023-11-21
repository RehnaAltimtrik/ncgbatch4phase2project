package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    Booking findByBookingId(int bookingId);

}

