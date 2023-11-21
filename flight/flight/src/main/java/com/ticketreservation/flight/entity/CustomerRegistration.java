package com.ticketreservation.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class CustomerRegistration {
    @Id
    @GeneratedValue(generator = "details",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="details",allocationSize = 100,initialValue = 50000,sequenceName ="trainsequence")

    private int customerId;

    @NotBlank(message = "enter customer name")
    private String customerName;

    @Past(message = "DOB should not be a future Date")
    private Date dob;

    @NotNull(message = "Enter Valid Email")
    private String email;

    @Column(name="password",length=50,nullable = false)
    private String password;

    @NotNull(message="Enter ssnType")
    private String ssnType;

    @NotNull(message="Enter a valid ssnNo")
    private String ssnNo;

    @JsonIgnore
    @OneToMany(mappedBy = "customerRegistration", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Booking> book;


}

