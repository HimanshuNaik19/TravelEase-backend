package com.himanshu.TravelEase.repository;

import com.himanshu.TravelEase.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
}
