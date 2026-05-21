package com.example.air_time_manager.controllers;

import com.example.air_time_manager.model.requestbodies.FlightData;
import com.example.air_time_manager.services.FlightService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<?> getFlight(@PathVariable @Validated @NotNull Long id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(flightService.getFlight(id));
    }

    @PostMapping("/flights")
    public ResponseEntity<?> postFlight(@NotNull @Validated @RequestBody FlightData flightData) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(flightService.saveFlight(flightData));
    }

}
