package com.example.air_time_manager.controllers;

import com.example.air_time_manager.model.requestbodies.AirportData;
import com.example.air_time_manager.services.AirportService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airports")
    public ResponseEntity<?> getAirports() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airportService.getAirports());
    }

    @GetMapping("/airports/{name}")
    public ResponseEntity<?> getAirport(@PathVariable @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airportService.getAirport(name));
    }

    @PostMapping("/airports")
    public ResponseEntity<?> saveAirport(@RequestBody @NotNull AirportData airportData) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airportService.saveAirport(airportData));
    }

    @DeleteMapping("/airports/{name}")
    public ResponseEntity<?> deleteAirport(@PathVariable @NotNull String name) {
        airportService.deleteAirport(name);
        return ResponseEntity.noContent().build();
    }

}
