package com.example.parkinglot.controllers;

import com.example.parkinglot.models.ParkingSpot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.Vehicle;
import com.example.parkinglot.services.ParkingLot;
import java.util.Optional;

public class EntryGate {
    private String gateId;
    private ParkingLot lot;

    public EntryGate(String gateId, ParkingLot lot) {
        this.gateId = gateId;
        this.lot = lot;
    }

    public Optional<Ticket> generateTicket(Vehicle vehicle) {
        Optional<ParkingSpot> spotOptional = lot.findSpotForVehicle(vehicle);
        if (spotOptional.isPresent()) {
            Ticket ticket = lot.parkVehicle(vehicle, spotOptional.get());
            return Optional.of(ticket);
        }
        System.out.println("No available spot for vehicle: " + vehicle.getVehicleNo());
        return Optional.empty();
    }
}