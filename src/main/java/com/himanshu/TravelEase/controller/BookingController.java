package com.himanshu.TravelEase.controller;

import com.himanshu.TravelEase.model.Booking;
import com.himanshu.TravelEase.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking, @AuthenticationPrincipal OAuth2User oauth2User) {
        // Extract user ID from the authenticated principal
        String userId = oauth2User.getAttribute("login"); 
        booking.setUserId(userId);
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings(@AuthenticationPrincipal OAuth2User oauth2User) {
        String userId = oauth2User.getAttribute("login");
        return bookingService.getBookingsByUserId(userId);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}
