package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.Airline;
import com.ticketreservation.flight.service.IAirlineService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path="/airline-api")

public class AirlineController {
    Logger logger= LoggerFactory.getLogger(AirlineController.class);
    private final IAirlineService iAirlineService;
    @Autowired
    public AirlineController( IAirlineService iAirlineService){
        this.iAirlineService=iAirlineService;
    }
    @PostMapping(path="/aero")
    @ResponseBody
    public Airline createAirlineDetails(@Valid @RequestBody Airline airline1){
        logger.info("Creating a airline Details");
        return iAirlineService.createAirlineDetails(airline1);
    }
    @GetMapping(path = "/allairline")
    @ResponseBody
    public List<Airline> getAllAirline() {try{
        logger.info("getting airline details");
        return iAirlineService.getAllAirline();}
    catch(Exception e){
        return Collections.emptyList();

    }

    }


}

