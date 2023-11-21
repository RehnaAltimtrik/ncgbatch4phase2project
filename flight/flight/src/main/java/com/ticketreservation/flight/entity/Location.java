package com.ticketreservation.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Location {
    @Id
    @NotNull(message = "Enter location id as a number")
    private String  locationId;

    @NotBlank(message = "must enter the location name")
    private String locationName;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private List<Flight> flight;

    public Location(int i, String locationName) {
    }
}


