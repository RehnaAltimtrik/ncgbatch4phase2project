package com.ticketreservation.flight.service;

import com.ticketreservation.flight.entity.CustomerRegistration;
import com.ticketreservation.flight.repository.ILoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService {

    private final ILoginRepo iLoginRepo;
    @Autowired

    public LoginServiceImpl(ILoginRepo iLoginRepo) {
        this.iLoginRepo = iLoginRepo;
    }

    @Override
    public boolean doLogin(String email, String password) {
        Optional<CustomerRegistration> login=iLoginRepo.findByEmailAndPassword(email,password);
        return login.isPresent();
    }
}


