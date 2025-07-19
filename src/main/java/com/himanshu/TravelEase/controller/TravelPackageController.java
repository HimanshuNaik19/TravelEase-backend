package com.himanshu.TravelEase.controller;

import com.himanshu.TravelEase.model.TravelPackage;
import com.himanshu.TravelEase.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public List<TravelPackage> getAllTravelPackages() {
        return travelPackageService.getAllTravelPackages();
    }

    @GetMapping("/{id}")
    public TravelPackage getTravelPackageById(@PathVariable Long id) {
        return travelPackageService.getTravelPackageById(id);
    }

    @PostMapping
    public TravelPackage addTravelPackage(@RequestBody TravelPackage travelPackage) {
        return travelPackageService.addTravelPackage(travelPackage);
    }

    @PutMapping("/{id}")
    public TravelPackage updateTravelPackage(@PathVariable Long id, @RequestBody TravelPackage packageDetails) {
        return travelPackageService.updateTravelPackage(id, packageDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTravelPackage(@PathVariable Long id) {
        travelPackageService.deleteTravelPackage(id);
    }
}
