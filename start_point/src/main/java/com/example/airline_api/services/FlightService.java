package com.example.airline_api.services;


import com.example.airline_api.Repositories.FlightRepository;
import com.example.airline_api.Repositories.PassengerRepository;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;



@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

//    @Autowired
//    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(long id){
        return flightRepository.findById(id);
    }

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public Flight addPassengerToFlight(Flight flight, Passenger passenger){
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        return flightRepository.save(flight);
    }

    public void cancelFlight(Long id){
        flightRepository.deleteById(id);
    }


}
