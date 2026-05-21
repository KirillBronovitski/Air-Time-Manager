package com.example.air_time_manager.controllers;

import com.example.air_time_manager.model.requestbodies.DeletionConfirmation;
import com.example.air_time_manager.model.requestbodies.PlaneData;
import com.example.air_time_manager.services.PlaneService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping("/planes/{planeName}")
    public ResponseEntity<?> getPlane(@PathVariable @Validated @NotNull String planeName) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlane(planeName));
    }

    @GetMapping("/planes")
    public ResponseEntity<?> getAllPlanes() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getAllPlanes());
    }

    @GetMapping("/planes/{name}/home-time")
    public ResponseEntity<?> getHomeTimeOfPlane(@PathVariable @Validated @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getHomeTimeOfPlane(name));
    }

    @GetMapping("/planes/{name}/local-time")
    public ResponseEntity<?> getLocalTimeOfPlane(@PathVariable @Validated @NotNull String name) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getLocalTimeOfPlane(name));
    }

    @GetMapping("/planes-at-airport/{airport}")
    public ResponseEntity<?> getPlanesAtAirport(@PathVariable @Validated @NotNull String airport) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlanesAtAirport(airport));
    }

    @GetMapping("/planes-of-airline/{airline}")
    public ResponseEntity<?> getPlanesOfAirline(@PathVariable @Validated @NotNull String airline) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.getPlanesOfAirline(airline));
    }

    @PostMapping("/planes")
    public ResponseEntity<?> savePlane(@RequestBody @Validated @NotNull PlaneData planeData) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.savePlane(planeData));
    }

    @DeleteMapping("/planes/{name}")
    public ResponseEntity<?> deletePlane(@PathVariable @Validated @NotNull String name, @RequestBody @Validated @NotNull DeletionConfirmation deletionConfirmation) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.deletePlane(name, deletionConfirmation));
    }

    @DeleteMapping("/planes")
    public ResponseEntity<?> deleteAllPlanes(@RequestBody @Validated @NotNull DeletionConfirmation deletionConfirmation) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(planeService.deleteALlPlanes(deletionConfirmation));
    }

}
