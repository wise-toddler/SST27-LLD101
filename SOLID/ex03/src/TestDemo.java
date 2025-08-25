public class TestDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing refactored ex03:");
        
        ShippingCostCalculator calculator = new ShippingCostCalculator();
        
        System.out.println("Expected: 96.0");
        System.out.print("Actual: ");
        System.out.println(calculator.cost(new Shipment("EXPRESS", 2.0)));
        
        System.out.println("\nTesting all types:");
        System.out.println("STANDARD 1kg: " + calculator.cost(new Shipment("STANDARD", 1.0)));
        System.out.println("EXPRESS 2kg: " + calculator.cost(new Shipment("EXPRESS", 2.0))); 
        try {
            System.out.println("OVERNIGHTTTTT 0.5kg: " + calculator.cost(new Shipment("OVERNIGHTTT", 0.5)));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}