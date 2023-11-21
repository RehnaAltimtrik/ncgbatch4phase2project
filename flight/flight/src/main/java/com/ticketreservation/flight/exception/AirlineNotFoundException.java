package com.ticketreservation.flight.exception;

public class AirlineNotFoundException extends Exception {
    public AirlineNotFoundException(String message){
        super(message);
    }
}
