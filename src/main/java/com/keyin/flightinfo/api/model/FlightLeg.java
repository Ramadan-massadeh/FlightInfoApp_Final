package com.keyin.flightinfo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight_legs")
public class FlightLeg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime departAt;
    private LocalDateTime arriveAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "aircraft_id")
    @JsonIgnoreProperties({"passengers","legs"})
    private Aircraft aircraft;

    @ManyToOne(optional = false)
    @JoinColumn(name = "from_airport_id")
    @JsonIgnoreProperties({"city","departures","arrivals"})
    private Airport fromAirport;

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_airport_id")
    @JsonIgnoreProperties({"city","departures","arrivals"})
    private Airport toAirport;

    public FlightLeg() {}

    public FlightLeg(LocalDateTime departAt, LocalDateTime arriveAt, Aircraft aircraft,
                     Airport fromAirport, Airport toAirport) {
        this.departAt = departAt;
        this.arriveAt = arriveAt;
        this.aircraft = aircraft;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDepartAt() { return departAt; }
    public void setDepartAt(LocalDateTime departAt) { this.departAt = departAt; }

    public LocalDateTime getArriveAt() { return arriveAt; }
    public void setArriveAt(LocalDateTime arriveAt) { this.arriveAt = arriveAt; }

    public Aircraft getAircraft() { return aircraft; }
    public void setAircraft(Aircraft aircraft) { this.aircraft = aircraft; }

    public Airport getFromAirport() { return fromAirport; }
    public void setFromAirport(Airport fromAirport) { this.fromAirport = fromAirport; }

    public Airport getToAirport() { return toAirport; }
    public void setToAirport(Airport toAirport) { this.toAirport = toAirport; }
}