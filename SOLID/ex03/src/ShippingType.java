public enum ShippingType 
{
    STANDARD(50, 5), 
    EXPRESS(80, 8), 
    OVERNIGHT(120, 10);
    
    private final double baseCost;
    private final double ratePerKg;
    
    ShippingType(double baseCost, double ratePerKg) 
    {
        this.baseCost = baseCost;
        this.ratePerKg = ratePerKg;
    }
    
    public double calculateCost(double weightKg) 
    {
        return baseCost + ratePerKg * weightKg;
    }
}