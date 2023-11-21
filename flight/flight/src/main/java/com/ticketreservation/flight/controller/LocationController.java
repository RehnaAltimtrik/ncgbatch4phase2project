package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.Location;
import com.ticketreservation.flight.service.ILocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/air-location")

public class LocationController {

    private final ILocationService iLocationService;
    @Autowired

    public LocationController(ILocationService iLocationService) {
        this.iLocationService = iLocationService;
    }

    @ResponseBody
    @PostMapping(path="/loc")
    public Location createLocation(@Valid @RequestBody Location loc){
        return iLocationService.createLocation(loc);
    }
    @ResponseBody
    @GetMapping(path="/get")
    public List<Location> getAllLocation(){
        return iLocationService.getAllLocation();
    }
    @ResponseBody
    @GetMapping(path="/{location_id}")
    public Location getLocationById(@PathVariable("location_id") int locationId){
        return  iLocationService.getLocationByID(locationId);
    }
}
