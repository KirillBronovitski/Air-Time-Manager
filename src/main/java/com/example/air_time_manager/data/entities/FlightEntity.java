package com.example.air_time_manager.data.entities;

import jakarta.persistence.*;

@Entity
public class FlightEntity {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private PlaneEntity plane;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private AirportEntity from;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    private AirportEntity to;

    @Column
    private String UTCStartTime;

    @Column
    private String UTCEndTime;

    public FlightEntity() {}

    public FlightEntity(PlaneEntity plane, AirportEntity from, AirportEntity to, String UTCStartTime, String UTCEndTime) {
        this.plane = plane;
        this.from = from;
        this.to = to;
        this.UTCStartTime = UTCStartTime;
        this.UTCEndTime = UTCEndTime;
    }


    public Long getId() {
        return id;
    }

    public PlaneEntity getPlane() {
        return plane;
    }

    public AirportEntity getFrom() {
        return from;
    }

    public AirportEntity getTo() {
        return to;
    }

    public String getUTCStartTime() {
        return UTCStartTime;
    }

    public String getUTCEndTime() {
        return UTCEndTime;
    }
}
