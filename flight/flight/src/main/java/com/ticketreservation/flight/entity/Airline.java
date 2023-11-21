package com.ticketreservation.flight.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class Airline {
    @Id
    @Column(insertable = false, updatable = false)
    private int airId;


   @NotNull(message = "Please enter airline name")
    @Column(name = "air_name")
    private String airName;

  @NotNull(message = "dop should not be empty")
    private Date dop;
}
