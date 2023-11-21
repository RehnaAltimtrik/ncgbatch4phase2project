

package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.CustomerRegistration;
import com.ticketreservation.flight.exception.IdNotFoundException;
import com.ticketreservation.flight.service.ICustomerRegistrationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/airline-ticket")

public class CustomerRegistrationController {
    Logger logger= LoggerFactory.getLogger(CustomerRegistrationController.class);

    private final ICustomerRegistrationService icRegistrationService;
    @Autowired

    public CustomerRegistrationController(ICustomerRegistrationService icRegistrationService) {
        this.icRegistrationService = icRegistrationService;
    }

    @ResponseBody
    @PostMapping("/cus")

    public CustomerRegistration createCustomer(@RequestBody @Valid CustomerRegistration customerRegistration)
    {
        logger.info("Creating Customer Details");
        return icRegistrationService.createCustomer(customerRegistration);
    }
    @GetMapping(path="/cus1")
    public List<CustomerRegistration> getAllCustomer(){
        return icRegistrationService.getAllCustomer();
    }
    @ResponseBody
    @GetMapping(path="/{customerId}")
    public Optional<CustomerRegistration> getCustomerById(@PathVariable("customerId") int customerId) throws IdNotFoundException {
            if (icRegistrationService.getCustomerById(customerId).isEmpty()) {
                throw new IdNotFoundException("Id not found exception");
            }
            return icRegistrationService.getCustomerById(customerId);
        }
        @ResponseBody
        @PutMapping("/put")
        public CustomerRegistration updateCustomer (@RequestBody CustomerRegistration customerRegistration){
            return icRegistrationService.updateCustomer(customerRegistration);


        }
        @DeleteMapping(path = "/customer/{id}")
        public Optional<CustomerRegistration> deleteCustomer ( @PathVariable("id") int cId){
            return icRegistrationService.deleteCustmomer(cId);


        }

    }


