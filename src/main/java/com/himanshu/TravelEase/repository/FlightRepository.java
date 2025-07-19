package com.himanshu.TravelEase.repository;

import com.himanshu.TravelEase.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureCityAndArrivalCity(String departureCity, String arrivalCity);
}
