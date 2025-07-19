package com.himanshu.TravelEase.service;

import com.himanshu.TravelEase.model.Booking;
import com.himanshu.TravelEase.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        booking.setBookingDate(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(String userId) {

        return bookingRepository.findByUserId(userId);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
