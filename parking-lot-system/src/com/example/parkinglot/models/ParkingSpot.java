package com.example.parkinglot.models;

import com.example.parkinglot.models.vehicles.Vehicle;

public class ParkingSpot {
    private String spotId;
    private boolean isAvailable;
    private Vehicle vehicle;
    private boolean hasElectricCharger;

    public ParkingSpot(String spotId, boolean hasElectricCharger) {
        this.spotId = spotId;
        this.hasElectricCharger = hasElectricCharger;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean hasElectricCharger() {
        return hasElectricCharger;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}