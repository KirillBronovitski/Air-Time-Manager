package com.example.air_time_manager.model;


public class Flight {

    private Long id;

    private String plane;

    private String from;

    private String to;

    private String UTCStartTime;

    private String UTCEndTime;

    public Flight(Long id, String plane, String from, String to, String UTCStartTime, String UTCEndTime) {
        this.id = id;
        this.plane = plane;
        this.from = from;
        this.to = to;
        this.UTCStartTime = UTCStartTime;
        this.UTCEndTime = UTCEndTime;
    }

    public Long getId() {
        return id;
    }

    public String getPlane() {
        return plane;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getUTCStartTime() {
        return UTCStartTime;
    }

    public String getUTCEndTime() {
        return UTCEndTime;
    }
}
