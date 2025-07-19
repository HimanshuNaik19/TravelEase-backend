package com.himanshu.TravelEase.controller;

import com.himanshu.TravelEase.model.Flight;
import com.himanshu.TravelEase.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String departureCity, @RequestParam String arrivalCity) {
        return flightService.searchFlights(departureCity, arrivalCity);
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}
