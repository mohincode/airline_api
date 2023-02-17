package com.example.airline_api.services;

import com.example.airline_api.Repositories.PassengerRepository;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(long id){
        return passengerRepository.findById(id);
    }

    public Passenger addNewPassenger(Passenger passenger){
        passengerRepository.save(passenger);
        return passenger;
    }

}