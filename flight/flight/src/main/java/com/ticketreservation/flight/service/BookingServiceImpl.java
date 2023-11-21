package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Booking;
import com.ticketreservation.flight.repository.BookingRepo;
import com.ticketreservation.flight.repository.IFlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookingServiceImpl implements IBookingService{


    private final BookingRepo bookingRepo;



    private final IFlightRepo iFlightRepo;
    @Autowired

    public BookingServiceImpl(BookingRepo bookingRepo,  IFlightRepo iFlightRepo) {
        this.bookingRepo = bookingRepo;

        this.iFlightRepo = iFlightRepo;
    }

    @Override
    public Booking bookFlight(Booking book) {
        book.setFlight(iFlightRepo.findById(book.getFNo()));

        return bookingRepo.save(book);
    }



    @Override
    public List<Booking> getAllBooking() {

        return bookingRepo.findAll();
    }

    @Override
    public Booking findByBookingId(int bookingId) {
        try{
        return bookingRepo.findByBookingId(bookingId);
        }catch (Exception e){
            return null;

        }

    }


}

