package com.keyin.flightinfo.api.controller;

import com.keyin.flightinfo.api.model.Aircraft;
import com.keyin.flightinfo.api.model.Airport;
import com.keyin.flightinfo.api.repository.AircraftRepository;
import com.keyin.flightinfo.api.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final AircraftRepository aircraftRepo;
    private final AirportRepository airportRepo;

    @GetMapping("/{pid}/aircraft")
    public List<Aircraft> getAircraftFlownByPassenger(@PathVariable Long pid) {
        return aircraftRepo.findAircraftByPassengerId(pid);
    }

    @GetMapping("/{pid}/airports")
    public List<Airport> getAirportsUsedByPassenger(@PathVariable Long pid) {
        return airportRepo.findAll();
    }
}