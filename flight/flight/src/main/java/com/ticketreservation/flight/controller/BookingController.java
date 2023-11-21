package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.Booking;
import com.ticketreservation.flight.service.IBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="ticket-booking")

public class BookingController {
    Logger logger= LoggerFactory.getLogger(BookingController.class);

    private  final IBookingService iBookingService;
    @Autowired

    public BookingController(IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }

    @ResponseBody
    @PostMapping(path="/book")
    public Booking bookFlight(@RequestBody Booking book){
        logger.info("Flight booking");
        return iBookingService.bookFlight(book);
    }
    @ResponseBody
    @GetMapping(path="/book1")
    public List<Booking> getAllBooking(){
        logger.info("Getting Booking details");

        return iBookingService.getAllBooking();
    }
    @ResponseBody
    @GetMapping(path="/{bookingId}")
    public Booking findByBookingId(@PathVariable("bookingId") int bookingId){
        logger.info("Booking byId");
        return iBookingService.findByBookingId(bookingId);
    }

}

