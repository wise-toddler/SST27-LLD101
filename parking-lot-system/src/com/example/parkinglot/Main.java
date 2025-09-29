package com.example.parkinglot;

import com.example.parkinglot.controllers.EntryGate;
import com.example.parkinglot.controllers.ExitGate;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.vehicles.Car;
import com.example.parkinglot.models.vehicles.ElectricCar;
import com.example.parkinglot.services.ParkingLot;
import com.example.parkinglot.strategies.PerHourPricingStrategy;
import com.example.parkinglot.strategies.PricingStrategy;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup
        ParkingLot parkingLot = new ParkingLot(5, 10, 2, 3); // car, bike, bus, ev spots
        PricingStrategy pricingStrategy = new PerHourPricingStrategy();

        EntryGate entryGate = new EntryGate("Entry1", parkingLot);
        ExitGate exitGate = new ExitGate("Exit1", parkingLot, pricingStrategy);

        // 2. Simulate a regular car entering and exiting
        System.out.println("--- Scenario 1: A Regular Car ---");
        Car car = new Car("KA-01-HH-1234");
        Optional<Ticket> carTicketOpt = entryGate.generateTicket(car);

        if (carTicketOpt.isPresent()) {
            Ticket carTicket = carTicketOpt.get();
            System.out.println("Car parked. Ticket ID: " + carTicket.getTicketId());

            // Wait for 2 seconds to simulate parking duration
            Thread.sleep(2000);

            double fee = exitGate.processExitTicket(carTicket.getTicketId());
            System.out.println("Car exited. Parking fee: $" + fee);
        } else {
            System.out.println("No available spots for car!");
        }

        // 3. Simulate an electric car entering and exiting
        System.out.println("\n--- Scenario 2: An Electric Car ---");
        ElectricCar electricCar = new ElectricCar("KA-02-HH-5678");
        Optional<Ticket> eCarTicketOpt = entryGate.generateTicket(electricCar);

        if (eCarTicketOpt.isPresent()) {
            Ticket eCarTicket = eCarTicketOpt.get();
            System.out.println("Electric car parked with charging. Ticket ID: " + eCarTicket.getTicketId());

            Thread.sleep(1000); // Simulate charging time

            double fee = exitGate.processExitTicket(eCarTicket.getTicketId());
            System.out.println("Electric car exited. Parking fee: $" + fee);
        } else {
            System.out.println("No available charging spots for electric car!");
        }
    }
}