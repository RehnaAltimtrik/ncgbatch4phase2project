package com.ticketreservation.flight;

import com.ticketreservation.flight.controller.BookingController;
import com.ticketreservation.flight.entity.Booking;
import com.ticketreservation.flight.service.IBookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;


import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

 class BookingControllerTest {
    @Mock
private IBookingService iBookingService;

    @InjectMocks
    private BookingController bookingController;

    private MockMvc mockMvc;


    @Test
    void testBookFlight() throws Exception {

        when(iBookingService.bookFlight(Mockito.any(Booking.class)))
                .thenReturn(new Booking());

        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/book")
                        .content("{ \"property\": \"value\" }")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void testGetAllBooking() throws Exception {
        when(iBookingService.getAllBooking())
                .thenReturn(Arrays.asList(new Booking()));

        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/book1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("get").value("value"));

    }
}

