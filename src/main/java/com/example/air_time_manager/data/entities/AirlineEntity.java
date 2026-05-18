package com.example.air_time_manager.data.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (
        name = "AIRLINE_ENTITY",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NAME"})
})
public class AirlineEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    private List<PlaneEntity> planes;

    public AirlineEntity() {}

    public AirlineEntity(String name) {
        this.name = name;
        planes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PlaneEntity> getPlanes() {
        return planes;
    }
}
