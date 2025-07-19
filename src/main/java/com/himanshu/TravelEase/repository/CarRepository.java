package com.himanshu.TravelEase.repository;

import com.himanshu.TravelEase.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCity(String city);
}
