package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;


    // Display a specified flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> getFlightById(@PathVariable long id){
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()){
            return new ResponseEntity(flight , HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    // Display all flights
    @GetMapping()
    public ResponseEntity<Flight> getAllFlights(){
        return null;
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(){
        return null;
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long id, @RequestBody Passenger passenger) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            Flight updatedFlight = flightService.addPassengerToFlight(flight.get(), passenger);
            return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }


    //

}
