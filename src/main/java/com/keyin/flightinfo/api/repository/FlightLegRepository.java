package com.keyin.flightinfo.api.repository;

import com.keyin.flightinfo.api.model.FlightLeg;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightLegRepository extends JpaRepository<FlightLeg, Long> {

    List<FlightLeg> findByAircraft_Id(Long aircraftId);
}