package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.CustomerRegistration;
import com.ticketreservation.flight.repository.ICustomerRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


    @Service

    public class CustomerRegistrationServiceImpl implements ICustomerRegistrationService{

        private final ICustomerRegistrationRepo icRegistrationRepo;
        @Autowired

        public CustomerRegistrationServiceImpl(ICustomerRegistrationRepo icRegistrationRepo) {

            this.icRegistrationRepo = icRegistrationRepo;
        }

        @Override
        public CustomerRegistration createCustomer(CustomerRegistration customerRegistration) {

            return  icRegistrationRepo.save(customerRegistration);

        }


        @Override
        public List<CustomerRegistration> getAllCustomer() {

            return icRegistrationRepo.findAll();
        }

        @Override
        public Optional<CustomerRegistration> getCustomerById(int customerId) {
            Optional<CustomerRegistration> opt =icRegistrationRepo.findById(customerId);
            CustomerRegistration customerRegistration=null;
            if(opt.isPresent()){
                customerRegistration=opt.get();
            }
            return Optional.ofNullable(customerRegistration);
        }

        @Override
        public CustomerRegistration updateCustomer(CustomerRegistration customerRegistration) {
            Optional<CustomerRegistration> opt=icRegistrationRepo.findById(customerRegistration.getCustomerId());
            if(opt.isPresent()){
                icRegistrationRepo.save(customerRegistration);
            }
            return customerRegistration;
        }


        @Override
        public Optional<CustomerRegistration> deleteCustmomer(int customerId) {
            icRegistrationRepo.deleteById(customerId);
            return  icRegistrationRepo.findById(customerId);
        }


    }



