package com.himanshu.TravelEase.service;

import com.himanshu.TravelEase.model.Hotel;
import com.himanshu.TravelEase.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();
    }

    public List<Hotel> searchHotels(String city) {

        return hotelRepository.findByCity(city);
    }

    public Hotel addHotel(Hotel hotel) {

        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setName(hotelDetails.getName());
        hotel.setCity(hotelDetails.getCity());
        hotel.setStars(hotelDetails.getStars());
        hotel.setPricePerNight(hotelDetails.getPricePerNight());
        hotel.setAvailableRooms(hotelDetails.getAvailableRooms());
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
