interface Vehicle 
{
    // Base vehicle marker interface
}

interface EngineVehicle extends Vehicle 
{
    void startEngine();
}

interface PedalVehicle extends Vehicle 
{
    void pedal(int effort);
}

interface ElectricVehicle extends Vehicle 
{
    void recharge(int kWh);
}