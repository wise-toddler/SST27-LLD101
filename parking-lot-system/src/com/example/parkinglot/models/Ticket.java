package com.example.parkinglot.models;

import com.example.parkinglot.models.vehicles.Vehicle;

public class Ticket {
    private String ticketId;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = vehicle.getVehicleNo() + "_" + System.currentTimeMillis();
        this.entryTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}