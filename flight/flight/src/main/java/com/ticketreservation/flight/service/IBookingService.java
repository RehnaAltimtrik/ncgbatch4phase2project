package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Booking;

import java.util.List;

public interface IBookingService {
    public Booking bookFlight(Booking book);

    public List<Booking> getAllBooking();
    public Booking findByBookingId(int bookingId);


}

