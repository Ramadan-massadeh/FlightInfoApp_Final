package com.keyin.flightinfo.api.controller;

import com.keyin.flightinfo.api.model.Aircraft;
import com.keyin.flightinfo.api.model.FlightLeg;
import com.keyin.flightinfo.api.repository.AircraftRepository;
import com.keyin.flightinfo.api.repository.FlightLegRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftRepository aircraftRepo;
    private final FlightLegRepository flightLegRepo;


    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftRepo.findAll();
    }


    @GetMapping("/{aircraftId}/routes")
    public List<FlightLeg> getRoutes(@PathVariable Long aircraftId) {
        return flightLegRepo.findByAircraft_Id(aircraftId);
    }
}