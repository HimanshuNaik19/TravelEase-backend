package com.himanshu.TravelEase.service;

import com.himanshu.TravelEase.model.Flight;
import com.himanshu.TravelEase.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {

        return flightRepository.findAll();
    }

    public List<Flight> searchFlights(String departureCity, String arrivalCity) {
        return flightRepository.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
    }

    public Flight addFlight(Flight flight) {

        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setDepartureCity(flightDetails.getDepartureCity());
        flight.setArrivalCity(flightDetails.getArrivalCity());
        flight.setDepartureTime(flightDetails.getDepartureTime());
        flight.setArrivalTime(flightDetails.getArrivalTime());
        flight.setPrice(flightDetails.getPrice());
        flight.setAvailableSeats(flightDetails.getAvailableSeats());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
