package com.example.parkinglot.models.vehicles;

public class Bike extends Vehicle {
    public Bike(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}