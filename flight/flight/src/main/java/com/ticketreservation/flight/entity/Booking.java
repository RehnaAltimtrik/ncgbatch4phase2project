package com.ticketreservation.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor

public class Booking {
    @Id
    @Column(insertable=false, updatable=false)
    private int bookingId;

    @NotNull(message = "booking date should not be empty")
    private Date bookingDate;

    @NotNull(message = "Must enter the price ")
    private  int price;

    @NotNull(message="Enter the number of seats booked")
    private int seatsBook;

    @Future
    private Date departDate;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private CustomerRegistration customerRegistration;


    private int customerId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Flight flight;


    private int fNo;


}

