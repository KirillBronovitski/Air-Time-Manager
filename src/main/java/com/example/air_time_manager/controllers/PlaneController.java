package com.example.air_time_manager.controllers;

import com.example.air_time_manager.model.requestbodies.PlaneData;
import com.example.air_time_manager.services.PlaneService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping("/planes/{planeName}")
    public ResponseEntity<?> getPlane(@PathVariable @NotNull String planeName) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlane(planeName));
    }

    @GetMapping("/planes/{name}/home-time")
    public ResponseEntity<?> getHomeTimeOfPlane(@PathVariable @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getHomeTimeOfPlane(name));
    }

    @GetMapping("/planes/{name}/local-time")
    public ResponseEntity<?> getLocalTimeOfPlane(@PathVariable @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getLocalTimeOfPlane(name));
    }

    @GetMapping("/planes-at-airport/{airport}")
    public ResponseEntity<?> getPlanesAtAirport(@PathVariable @NotNull String airport) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlanesAtAirport(airport));
    }

    @GetMapping("/planes-of-airline/{airline}")
    public ResponseEntity<?> getPlanesOfAirline(@PathVariable @NotNull String airline) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlanesOfAirline(airline));
    }

    @PostMapping("/planes")
    public ResponseEntity<?> savePlane(@RequestBody @NotNull PlaneData planeData) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.savePlane(planeData));
    }

    @DeleteMapping("/planes/{name}")
    public ResponseEntity<?> deletePlane(@PathVariable @NotNull String name) {
        planeService.deletePlane(name);
        return ResponseEntity.noContent().build();
    }

}
