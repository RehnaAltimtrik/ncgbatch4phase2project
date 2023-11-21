package com.ticketreservation.flight.exception;

public class BookingIdNotFoundException extends Exception{
    public BookingIdNotFoundException(String message){
        super(message);
    }
}
