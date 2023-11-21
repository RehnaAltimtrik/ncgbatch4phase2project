package com.ticketreservation.flight.controller;

import com.ticketreservation.flight.entity.CustomerRegistration;
import com.ticketreservation.flight.service.LoginServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/airline")
public class LoginController {

    private final LoginServiceImpl loginService;
    @Autowired

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping(path="/login")
    @ResponseBody
    public boolean createLogin( @Valid @RequestBody CustomerRegistration customerRegistration){
        return loginService.doLogin(customerRegistration.getEmail(), customerRegistration.getPassword());

    }
}
