package com.keyin.flightinfo.api.controller;

import com.keyin.flightinfo.api.model.FlightLeg;
import com.keyin.flightinfo.api.repository.FlightLegRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/legs")
@CrossOrigin(origins = "*")
public class FlightLegController {

    private final FlightLegRepository legRepo;

    public FlightLegController(FlightLegRepository legRepo) {
        this.legRepo = legRepo;
    }

    @GetMapping
    public ResponseEntity<List<FlightLeg>> getAllLegs() {
        List<FlightLeg> legs = legRepo.findAll();
        return ResponseEntity.ok(legs);
    }

    @PostMapping
    public ResponseEntity<FlightLeg> createLeg(@RequestBody FlightLeg leg) {
        FlightLeg savedLeg = legRepo.save(leg);
        return ResponseEntity.ok(savedLeg);
    }
}