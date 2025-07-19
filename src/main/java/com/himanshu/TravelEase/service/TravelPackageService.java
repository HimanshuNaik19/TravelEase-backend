package com.himanshu.TravelEase.service;

import com.himanshu.TravelEase.model.TravelPackage;
import com.himanshu.TravelEase.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    public List<TravelPackage> getAllTravelPackages() {

        return travelPackageRepository.findAll();
    }

    public TravelPackage getTravelPackageById(Long id) {
        return travelPackageRepository.findById(id).orElseThrow(() -> new RuntimeException("TravelPackage not found"));
    }

    public TravelPackage addTravelPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    public TravelPackage updateTravelPackage(Long id, TravelPackage packageDetails) {
        TravelPackage travelPackage = travelPackageRepository.findById(id).orElseThrow(() -> new RuntimeException("TravelPackage not found"));
        travelPackage.setName(packageDetails.getName());
        travelPackage.setDescription(packageDetails.getDescription());
        travelPackage.setIncludedPlaces(packageDetails.getIncludedPlaces());
        travelPackage.setTotalCost(packageDetails.getTotalCost());
        return travelPackageRepository.save(travelPackage);
    }

    public void deleteTravelPackage(Long id) {

        travelPackageRepository.deleteById(id);
    }
}
