package com.ticketreservation.flight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Login {
    @Id
    private  String email;

    @NotBlank(message = "Customer Name should not be empty")
    private String password;
}
