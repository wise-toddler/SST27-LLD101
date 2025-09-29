# Parking Lot Management System

A comprehensive parking lot management system built with Java, demonstrating Object-Oriented Design principles and design patterns.

## Features

- **Multi-Vehicle Support**: Cars, Bikes, Buses, and Electric Vehicles
- **Electric Vehicle Charging**: Dedicated charging spots with additional fees
- **Dynamic Pricing**: Configurable hourly rates per vehicle type
- **Real-time Capacity Tracking**: Available vs occupied spots monitoring
- **Ticket Management**: Entry/exit ticket generation and validation
- **Comprehensive Testing**: Full test suite covering all scenarios

## System Architecture

### Core Components

```
src/com/example/parkinglot/
├── models/
│   ├── ParkingSpot.java      # Parking spot representation
│   ├── Ticket.java           # Parking ticket entity
│   └── vehicles/
│       ├── Vehicle.java      # Abstract base vehicle
│       ├── Car.java          # Regular car
│       ├── Bike.java         # Motorcycle/bike
│       ├── Bus.java          # Large vehicle
│       ├── ElectricCar.java  # Electric vehicle
│       └── ElectricVehicle.java # Charging interface
├── controllers/
│   ├── EntryGate.java        # Entry point management
│   └── ExitGate.java         # Exit processing & billing
├── services/
│   └── ParkingLot.java       # Core parking lot operations
├── strategies/
│   ├── PricingStrategy.java  # Pricing interface
│   └── PerHourPricingStrategy.java # Hourly pricing implementation
├── Main.java                 # Demo application
└── TestParkingLot.java      # Comprehensive test suite
```

## Design Patterns Used

- **Strategy Pattern**: Flexible pricing strategies
- **Factory Pattern**: Vehicle creation and management
- **Template Method**: Consistent entry/exit processing
- **Interface Segregation**: Separate concerns (ElectricVehicle interface)

## Pricing Structure

| Vehicle Type | Hourly Rate | Charging Fee |
|-------------|-------------|--------------|
| Bike        | $20/hour    | N/A          |
| Car         | $40/hour    | N/A          |
| Electric Car| $40/hour    | +$15 flat    |
| Bus         | $80/hour    | N/A          |

## Quick Start

### Build and Run
```bash
cd src
javac com/example/parkinglot/**/*.java com/example/parkinglot/*.java

# Run demo
java com.example.parkinglot.Main

# Run comprehensive tests
java com.example.parkinglot.TestParkingLot
```

### Sample Usage
```java
// Setup parking lot (5 cars, 10 bikes, 2 buses, 3 EV charging spots)
ParkingLot parkingLot = new ParkingLot(5, 10, 2, 3);
PricingStrategy pricing = new PerHourPricingStrategy();

EntryGate entry = new EntryGate("Entry1", parkingLot);
ExitGate exit = new ExitGate("Exit1", parkingLot, pricing);

// Park a vehicle
Car car = new Car("KA-01-HH-1234");
Optional<Ticket> ticket = entry.generateTicket(car);

// Process exit and calculate fee
if (ticket.isPresent()) {
    double fee = exit.processExitTicket(ticket.get().getTicketId());
    System.out.println("Parking fee: $" + fee);
}
```

## Test Coverage

The `TestParkingLot.java` provides comprehensive testing:

- ✅ **Basic Vehicle Parking**: Different vehicle types and pricing
- ✅ **Electric Vehicle Charging**: Automatic charging spot allocation
- ✅ **Capacity Management**: Full lot handling and spot tracking
- ✅ **Error Handling**: Invalid ticket processing
- ✅ **Real-time Monitoring**: Available spot counting

## System Requirements

- Java 8 or higher
- No external dependencies required