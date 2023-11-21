package com.ticketreservation.flight.repository;

import com.ticketreservation.flight.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILoginRepo extends JpaRepository<CustomerRegistration,String> {
    public Optional<CustomerRegistration> findByEmailAndPassword(String email, String password);

}

