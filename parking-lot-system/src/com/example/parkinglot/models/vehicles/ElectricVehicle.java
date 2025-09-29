package com.example.parkinglot.models.vehicles;

public interface ElectricVehicle {
    boolean wantsCharging();
    void setWantsChargingFlag(boolean flag);
}