package com.keyin.flightinfo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"airports"})
    private City city;

    @OneToMany(mappedBy = "fromAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"fromAirport", "toAirport", "aircraft"})
    private List<FlightLeg> departures = new ArrayList<>();

    @OneToMany(mappedBy = "toAirport", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"fromAirport", "toAirport", "aircraft"})
    private List<FlightLeg> arrivals = new ArrayList<>();

    public Airport() {}

    public Airport(String name, String code, City city) {
        this.name = name;
        this.code = code;
        this.city = city;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<FlightLeg> getDepartures() { return departures; }
    public void setDepartures(List<FlightLeg> departures) { this.departures = departures; }

    public List<FlightLeg> getArrivals() { return arrivals; }
    public void setArrivals(List<FlightLeg> arrivals) { this.arrivals = arrivals; }
}