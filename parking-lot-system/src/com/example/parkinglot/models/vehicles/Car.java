package com.example.parkinglot.models.vehicles;

public class Car extends Vehicle {
    public Car(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "Car";
    }
}