package com.ticketreservation.flight.exception;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message){
        super(message);
    }
}
