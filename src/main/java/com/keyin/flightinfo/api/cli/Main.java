package com.keyin.flightinfo.api.cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FlightManager manager = new FlightManager();

        System.out.println("===================================");
        System.out.println("      Flight Information CLI       ");
        System.out.println("===================================");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View all flights");
            System.out.println("2. Search flight by destination");
            System.out.println("3. Get airports in a city");
            System.out.println("4. Get aircraft flown by a passenger");
            System.out.println("5. Get airports used by a passenger");
            System.out.println("6. Get airports for an aircraft");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    manager.displayAllFlights();
                    break;
                case 2:
                    System.out.print("Enter destination: ");
                    String destination = input.nextLine();
                    manager.searchByDestination(destination);
                    break;
                case 3:
                    System.out.print("Enter city ID: ");
                    long cityId = input.nextLong();
                    manager.getAirportsInCity(cityId);
                    break;
                case 4:
                    System.out.print("Enter passenger ID: ");
                    long passengerId1 = input.nextLong();
                    manager.getAircraftByPassenger(passengerId1);
                    break;
                case 5:
                    System.out.print("Enter passenger ID: ");
                    long passengerId2 = input.nextLong();
                    manager.getAirportsByPassenger(passengerId2);
                    break;
                case 6:
                    System.out.print("Enter aircraft ID: ");
                    long aircraftId = input.nextLong();
                    manager.getAirportsByAircraft(aircraftId);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}