public class TaxCalculator
{
    private double taxRate = 0.18;
    
    public double calculateTotal(double subtotal)
    {
        return subtotal + subtotal * taxRate;
    }
}