package com.keyin.flightinfo.api;

import com.keyin.flightinfo.api.cli.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirTravelApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirTravelApiApplication.class, args);

        // Start CLI after API server runs
        Main.main(new String[]{});
    }
}