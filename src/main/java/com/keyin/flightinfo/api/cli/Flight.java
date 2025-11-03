package com.keyin.flightinfo.api.cli;

public class Flight {
    private String flightNumber;
    private String destination;
    private String departureTime;

    // Constructor
    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    // Display method
    public void displayFlightInfo() {
        System.out.println("Flight Number: " + flightNumber +
                " | Destination: " + destination +
                " | Departure Time: " + departureTime);
    }
}