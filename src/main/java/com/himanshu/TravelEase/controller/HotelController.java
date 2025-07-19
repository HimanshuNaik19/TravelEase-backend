package com.himanshu.TravelEase.controller;

import com.himanshu.TravelEase.model.Hotel;
import com.himanshu.TravelEase.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/search")
    public List<Hotel> searchHotels(@RequestParam String city) {
        return hotelService.searchHotels(city);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
        return hotelService.updateHotel(id, hotelDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }
}
