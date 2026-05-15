package com.example.air_time_manager.data;

import jakarta.persistence.*;

@Entity
@Table (uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class AirlineEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    public AirlineEntity() {}

    public AirlineEntity(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
