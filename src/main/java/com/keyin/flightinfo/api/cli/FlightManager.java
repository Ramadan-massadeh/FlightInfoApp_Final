package com.keyin.flightinfo.api.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FlightManager {

    private String getApiResponse(String endpoint) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            conn.disconnect();
            return response.toString();
        } catch (Exception e) {
            System.out.println("Error fetching data: " + e.getMessage());
            return "";
        }
    }

    // Display all flight legs from API
    public void displayAllFlights() {
        String json = getApiResponse("http://localhost:8090/api/legs");
        printFormattedJson(json, "Flights from API");
    }

    // Search flights by destination
    public void searchByDestination(String destination) {
        String json = getApiResponse("http://localhost:8090/api/legs");

        if (json.equals("[]") || json.isEmpty()) {
            System.out.println("\nNo flights available.");
            return;
        }

        boolean found = false;
        String[] flights = json.split("\\},\\{");
        System.out.println("\nSearching for flights to: " + destination);

        for (String flight : flights) {
            if (flight.toLowerCase().contains(destination.toLowerCase())) {
                found = true;
                printSingleFlight(flight);
            }
        }

        if (!found) {
            System.out.println("No flights found for destination: " + destination);
        }
    }

    // Get all airports for a specific city
    public void getAirportsInCity(long cityId) {
        String json = getApiResponse("http://localhost:8090/api/cities/" + cityId + "/airports");
        printFormattedJson(json, "Airports in City ID " + cityId);
    }

    // Get all aircraft flown by a passenger
    public void getAircraftByPassenger(long passengerId) {
        String json = getApiResponse("http://localhost:8090/api/passengers/" + passengerId + "/aircraft");
        printFormattedJson(json, "Aircraft flown by Passenger ID " + passengerId);
    }

    // Get all airports used by a passenger
    public void getAirportsByPassenger(long passengerId) {
        String json = getApiResponse("http://localhost:8090/api/passengers/" + passengerId + "/airports");
        printFormattedJson(json, "Airports used by Passenger ID " + passengerId);
    }

    // Get all airports where an aircraft takes off or lands
    public void getAirportsByAircraft(long aircraftId) {
        String json = getApiResponse("http://localhost:8090/api/aircraft/" + aircraftId + "/routes");
        printFormattedJson(json, "Airports for Aircraft ID " + aircraftId);
    }

    // display API response
    private void printFormattedJson(String json, String title) {
        if (json.equals("[]") || json.isEmpty()) {
            System.out.println("\nNo data available for " + title);
            return;
        }

        System.out.println("\n=== " + title + " ===");
        String[] items = json.split("\\},\\{");

        for (String item : items) {
            printSingleFlight(item);
        }
    }

    private void printSingleFlight(String data) {
        data = data.replace("{", "").replace("}", "").replace("[", "").replace("]", "");
        String[] fields = data.split(",");
        System.out.println("----------------------------------------");
        for (String field : fields) {
            String[] keyValue = field.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().replace("\"", "");
                String value = keyValue[1].trim().replace("\"", "");
                System.out.println(capitalize(key) + ": " + value);
            }
        }
    }


    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}