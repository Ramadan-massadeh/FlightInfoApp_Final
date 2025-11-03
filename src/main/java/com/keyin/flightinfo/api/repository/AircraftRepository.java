package com.keyin.flightinfo.api.repository;

import com.keyin.flightinfo.api.model.Aircraft;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    @Query("""
       select distinct a
       from com.keyin.flightinfo.api.model.Passenger p
       join p.aircraft a
       where p.id = :pid
    """)
    List<Aircraft> findAircraftByPassengerId(@Param("pid") Long passengerId);
}