package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.CustomerRegistration;

import java.util.List;
import java.util.Optional;

public interface ICustomerRegistrationService {
    public CustomerRegistration createCustomer(CustomerRegistration customerRegistration);
    List<CustomerRegistration> getAllCustomer();
    public Optional<CustomerRegistration> getCustomerById(int cId);
    public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration);
    public Optional<CustomerRegistration> deleteCustmomer(int cId);

}


