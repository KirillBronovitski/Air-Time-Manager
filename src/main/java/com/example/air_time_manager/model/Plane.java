package com.example.air_time_manager.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Plane {

    private Long id;

    private String name;

    private String homeAirport;

    private String currentAirport;

    private String airline;

    @JsonCreator
    public Plane(Long id, String name, String homeAirport, String currentAirport, String airline) {
        this.id = id;
        this.name = name;
        this.homeAirport = homeAirport;
        this.currentAirport = currentAirport;
        this.airline = airline;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeAirport() {
        return homeAirport;
    }

    public String getAirline() {
        return airline;
    }

    public String getCurrentAirport() {
        return currentAirport;
    }
}
