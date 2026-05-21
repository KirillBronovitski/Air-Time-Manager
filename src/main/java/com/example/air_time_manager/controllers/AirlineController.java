package com.example.air_time_manager.controllers;

import com.example.air_time_manager.model.requestbodies.AirlineData;
import com.example.air_time_manager.model.requestbodies.DeletionConfirmation;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.air_time_manager.services.AirlineService;

@RestController
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airlines")
    public ResponseEntity<?> getAirlines() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airlineService.getAirlines());
    }

    @GetMapping("/airlines/{name}")
    public ResponseEntity<?> getAirline(@PathVariable @Validated @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airlineService.getAirline(name));
    }

    @PostMapping("/airlines")
    public ResponseEntity<?> saveAirline(@RequestBody @Validated @NotNull AirlineData airlineData) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airlineService.saveAirline(airlineData));
    }

    @DeleteMapping("/airlines/{name}")
    public ResponseEntity<?> deleteAirline(@PathVariable @Validated @NotNull String name, @RequestBody @Validated @NotNull DeletionConfirmation deletionConfirmation) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airlineService.deleteAirline(name, deletionConfirmation));
    }

    @DeleteMapping("/airlines")
    public ResponseEntity<?> deleteAllAirlines(@RequestBody @Validated @NotNull DeletionConfirmation deletionConfirmation) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(airlineService.deleteAllAirlines(deletionConfirmation));
    }

}
