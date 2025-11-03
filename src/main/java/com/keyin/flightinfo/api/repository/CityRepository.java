package com.keyin.flightinfo.api.repository;

import com.keyin.flightinfo.api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> { }