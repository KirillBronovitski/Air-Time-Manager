package com.example.air_time_manager.data.entities;

import jakarta.persistence.*;

@Table(
        name = "PLANE_ENTITY",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})}
)
@Entity
public class PlaneEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private AirportEntity homeAirport;

    @ManyToOne(cascade =  {CascadeType.DETACH, CascadeType.PERSIST})
    private AirportEntity currentAirport;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private AirlineEntity airline;

    public PlaneEntity() {}

    public PlaneEntity(String name, AirportEntity homeAirport, AirportEntity currentAirport, AirlineEntity airline) {
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

    public AirportEntity getHomeAirport() {
        return homeAirport;
    }

    public AirlineEntity getAirline() {
        return airline;
    }

    public AirportEntity getCurrentAirport() {
        return currentAirport;
    }

    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }
}
