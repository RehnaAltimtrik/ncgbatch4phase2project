package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.Flight;
import com.ticketreservation.flight.service.IFlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/flight1")
public class FlightController {

    private final IFlightService iFlightService;
    @Autowired

    public FlightController(IFlightService iFlightService) {
        this.iFlightService = iFlightService;
    }

    @PostMapping(path="/fly")
    @ResponseBody
    public Flight createFlightDetails(@Valid @RequestBody Flight fly)
    {

        return iFlightService.createFlightDetails(fly);
    }
    @GetMapping(path = "/fly1")
    @ResponseBody
    public List<Flight> getAllFlightDetails()
    {

        return iFlightService.getAllFlightDetails();
    }
    @GetMapping(path="/fly2")
    @ResponseBody
    public List<Flight> getFlights(@RequestParam int src, @RequestParam int dest) {
        return iFlightService.getFlightByCities(src,dest);
    }
    @ResponseBody
    @GetMapping(path="/{fNo}")
    public boolean doesFlightExist(@PathVariable("fNo") int fNo){

        return iFlightService.doesFlightExist(fNo);
    }

}

