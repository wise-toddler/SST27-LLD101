package com.example.parkinglot;

import com.example.parkinglot.controllers.EntryGate;
import com.example.parkinglot.controllers.ExitGate;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.*;
import com.example.parkinglot.services.ParkingLot;
import com.example.parkinglot.strategies.PerHourPricingStrategy;
import com.example.parkinglot.strategies.PricingStrategy;
import java.util.Optional;

public class TestParkingLot {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Parking Lot System Tests ===\n");

        // Setup
        ParkingLot parkingLot = new ParkingLot(2, 3, 1, 2); // Limited spots for testing
        PricingStrategy pricingStrategy = new PerHourPricingStrategy();

        EntryGate entryGate = new EntryGate("Entry1", parkingLot);
        ExitGate exitGate = new ExitGate("Exit1", parkingLot, pricingStrategy);

        System.out.println("Initial capacity: " + parkingLot.getAvailableSpots() + "/" + parkingLot.getTotalSpots() + " spots available\n");

        // Test 1: Park different vehicle types
        testVehicleParking(entryGate, exitGate);

        // Test 2: Electric vehicle charging
        testElectricVehicleCharging(entryGate, exitGate);

        // Test 3: Capacity limits
        testCapacityLimits(entryGate, parkingLot);

        // Test 4: Invalid ticket
        testInvalidTicket(exitGate);

        System.out.println("\n=== All Tests Completed ===");
    }

    private static void testVehicleParking(EntryGate entryGate, ExitGate exitGate) throws InterruptedException {
        System.out.println("TEST 1: Basic Vehicle Parking");

        // Test Car
        Car car = new Car("TEST-CAR-001");
        Optional<Ticket> carTicket = entryGate.generateTicket(car);
        if (carTicket.isPresent()) {
            System.out.println("✓ Car parked: " + carTicket.get().getTicketId());
            Thread.sleep(100); // Short parking duration
            double fee = exitGate.processExitTicket(carTicket.get().getTicketId());
            System.out.println("✓ Car exited with fee: $" + fee);
        }

        // Test Bike
        Bike bike = new Bike("TEST-BIKE-001");
        Optional<Ticket> bikeTicket = entryGate.generateTicket(bike);
        if (bikeTicket.isPresent()) {
            System.out.println("✓ Bike parked: " + bikeTicket.get().getTicketId());
            Thread.sleep(100);
            double fee = exitGate.processExitTicket(bikeTicket.get().getTicketId());
            System.out.println("✓ Bike exited with fee: $" + fee);
        }

        System.out.println();
    }

    private static void testElectricVehicleCharging(EntryGate entryGate, ExitGate exitGate) throws InterruptedException {
        System.out.println("TEST 2: Electric Vehicle Charging");

        ElectricCar eCar = new ElectricCar("TEST-ECAR-001");
        eCar.setWantsChargingFlag(true);

        Optional<Ticket> eCarTicket = entryGate.generateTicket(eCar);
        if (eCarTicket.isPresent()) {
            System.out.println("✓ Electric car parked at charging spot: " + eCarTicket.get().getTicketId());
            System.out.println("  Charging status: " + eCar.wantsCharging());
            System.out.println("  Spot has charger: " + eCarTicket.get().getParkingSpot().hasElectricCharger());

            Thread.sleep(100);
            double fee = exitGate.processExitTicket(eCarTicket.get().getTicketId());
            System.out.println("✓ Electric car exited with charging fee: $" + fee);
        }

        System.out.println();
    }

    private static void testCapacityLimits(EntryGate entryGate, ParkingLot parkingLot) {
        System.out.println("TEST 3: Capacity Limits");

        System.out.println("Available spots before: " + parkingLot.getAvailableSpots());

        // Try to park multiple vehicles to test capacity
        for (int i = 1; i <= 5; i++) {
            Car car = new Car("CAPACITY-TEST-" + i);
            Optional<Ticket> ticket = entryGate.generateTicket(car);
            if (ticket.isPresent()) {
                System.out.println("✓ Car " + i + " parked");
            } else {
                System.out.println("✗ Car " + i + " could not be parked (lot full)");
            }
        }

        System.out.println("Available spots after: " + parkingLot.getAvailableSpots());
        System.out.println();
    }

    private static void testInvalidTicket(ExitGate exitGate) {
        System.out.println("TEST 4: Invalid Ticket Handling");

        double fee = exitGate.processExitTicket("INVALID-TICKET-123");
        System.out.println("Fee for invalid ticket: $" + fee);
        System.out.println();
    }
}