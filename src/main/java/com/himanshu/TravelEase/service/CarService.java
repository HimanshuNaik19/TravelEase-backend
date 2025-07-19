package com.himanshu.TravelEase.service;

import com.himanshu.TravelEase.model.Car;
import com.himanshu.TravelEase.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    public List<Car> searchCars(String city) {

        return carRepository.findByCity(city);
    }

    public Car addCar(Car car) {

        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setModel(carDetails.getModel());
        car.setBrand(carDetails.getBrand());
        car.setCity(carDetails.getCity());
        car.setPricePerDay(carDetails.getPricePerDay());
        car.setAvailable(carDetails.isAvailable());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {

        carRepository.deleteById(id);
    }
}
