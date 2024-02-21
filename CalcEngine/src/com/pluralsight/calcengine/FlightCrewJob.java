package com.pluralsight.calcengine;

public enum FlightCrewJob {
    FLIGHT_ATTENDANT("Flight attendant"),
    CO_PILOT("Number one"),
    PILOT("Captain");

    private String title;
    public String getTitle() { return title; }
    private FlightCrewJob(String title) {
        this.title = title;
    }
}


