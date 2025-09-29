package com.example.parkinglot.strategies;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.ElectricVehicle;
import java.util.HashMap;
import java.util.Map;

public class PerHourPricingStrategy implements PricingStrategy {
    private Map<String, Double> rates = new HashMap<>();
    private double chargingFee;

    public PerHourPricingStrategy() {
        // Default rates per hour
        rates.put("Bike", 20.0);
        rates.put("Car", 40.0);
        rates.put("ElectricCar", 40.0);
        rates.put("Bus", 80.0);
        this.chargingFee = 15.0; // Flat fee for charging
    }

    @Override
    public double calculateFee(Ticket ticket, long exitTime) {
        long entryTime = ticket.getEntryTime();
        long durationInMillis = exitTime - entryTime;
        double hours = Math.ceil(durationInMillis / 3600000.0);

        String vehicleType = ticket.getVehicle().getType();
        double rate = rates.getOrDefault(vehicleType, 50.0); // Default rate if type not found

        double totalFee = hours * rate;

        // Add charging fee if applicable
        if (ticket.getParkingSpot().hasElectricCharger() && ticket.getVehicle() instanceof ElectricVehicle) {
            ElectricVehicle ev = (ElectricVehicle) ticket.getVehicle();
            if (ev.wantsCharging()) {
                totalFee += chargingFee;
            }
        }

        return totalFee;
    }
}