public class ShippingCostCalculator 
{
    public double cost(Shipment s)
    {
        try 
        {
            return ShippingType.valueOf(s.type).calculateCost(s.weightKg);
        } 
        catch (IllegalArgumentException e) 
        {
            throw new IllegalArgumentException("Unknown type: " + s.type);
        }
    }
}
