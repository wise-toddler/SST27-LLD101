package com.example.parkinglot.strategies;

import com.example.parkinglot.models.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket, long exitTime);
}