package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.Location;
import com.ticketreservation.flight.repository.LocationRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
 class LocationServiceTest {
    @Mock
    private LocationRepo locationRepo;
    @InjectMocks
    private LocationServiceImpl locationService;
    @Test
    void getAllLocation() {
        Location l1=
                new Location(2,"Delhi");
        Location l2= new Location(4,"kochin");
        List<Location> locationList= Arrays.asList(l1,l2);
        Mockito.when(locationRepo.findAll()).thenReturn(locationList);
        assertEquals(2,locationService.getAllLocation().size());
    }
}
