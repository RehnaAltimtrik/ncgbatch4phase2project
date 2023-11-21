package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRegistrationRepo extends JpaRepository<CustomerRegistration,Integer> {
}


