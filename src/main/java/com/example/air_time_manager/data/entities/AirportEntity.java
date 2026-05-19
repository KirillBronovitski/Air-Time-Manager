package com.example.air_time_manager.data.entities;

import jakarta.persistence.*;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Table(name = "AIRPORT_ENTITY")
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
    List<PlaneEntity> assignedPlanes;

    public AirportEntity() {}

    public AirportEntity(String name, ZoneId zoneId) {
        this.name = name;
        this.zoneId = zoneId;
        assignedPlanes = new ArrayList<>();
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
}
