package com.example.air_time_manager.data.entities;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Table(
        name = "AIRPORT_ENTITY",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})}
)
@Entity
public class AirportEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private ZoneId zoneId;

    @OneToMany(mappedBy = "homeAirport", cascade = {CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<PlaneEntity> assignedPlanes;

    @OneToMany(mappedBy = "currentAirport", cascade = {CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<PlaneEntity> planesAtAirport;

    public AirportEntity() {}

    public AirportEntity(String name, ZoneId zoneId) {
        this.name = name;
        this.zoneId = zoneId;
        assignedPlanes = new ArrayList<>();
        planesAtAirport = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public List<PlaneEntity> getAssignedPlanes() {
        return assignedPlanes;
    }

    public List<PlaneEntity> getPlanesAtAirport() {
        return planesAtAirport;
    }
}
