package com.ticketreservation.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private int fNo;

    @NotNull
    private int totalSeat;

    @NotNull
    private  int src;

    @NotNull
    private int dest;

    private String departTime;

    @NotNull
    private int fare;

    @Min(value = 1,message = "Please enter at least one value")
    private int availSeats;

    private Date departDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Airline airline;

    @Transient
    private int airId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Location source;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Location destination;

}

