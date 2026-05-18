package com.example.air_time_manager.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.ZoneId;
import java.util.List;

public class Airport {

    Long id;

    String name;

    ZoneId zoneId;

    List<String> planes;

    @JsonCreator
    public Airport(Long id, String name, ZoneId zoneId, List<String> planes) {
        this.id = id;
        this.name = name;
        this.zoneId = zoneId;
        this.planes = planes;
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

    public List<String> getPlanes() {
        return planes;
    }
}
