package com.example.parkinglot.controllers;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.services.ParkingLot;
import com.example.parkinglot.strategies.PricingStrategy;
import java.util.Optional;

public class ExitGate {
    private String gateId;
    private ParkingLot lot;
    private PricingStrategy pricingStrategy;

    public ExitGate(String gateId, ParkingLot lot, PricingStrategy pricingStrategy) {
        this.gateId = gateId;
        this.lot = lot;
        this.pricingStrategy = pricingStrategy;
    }

    public double processExitTicket(String ticketId) {
        Optional<Ticket> ticketOptional = lot.getActiveTicket(ticketId);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            long exitTime = System.currentTimeMillis();
            double fee = pricingStrategy.calculateFee(ticket, exitTime);
            lot.exitVehicle(ticketId);
            return fee;
        }
        System.out.println("Invalid ticket ID: " + ticketId);
        return 0.0;
    }
}