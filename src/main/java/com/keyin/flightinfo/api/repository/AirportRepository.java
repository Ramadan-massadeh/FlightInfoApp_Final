package com.keyin.flightinfo.api.repository;

import com.keyin.flightinfo.api.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByCity_Id(Long cityId);

    List<Airport> findAll();
}