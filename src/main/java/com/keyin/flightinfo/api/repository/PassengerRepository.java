package com.keyin.flightinfo.api.repository;

import com.keyin.flightinfo.api.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> { }