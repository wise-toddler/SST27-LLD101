public class TestDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing refactored code behavior:");
        
        EmailClient emailClient = new EmailClient();
        TaxCalculator taxCalculator = new TaxCalculator();
        OrderService orderService = new OrderService(emailClient, taxCalculator);
        
        System.out.println("Expected output:");
        System.out.println("[EMAIL to=a@shop.com] Thanks! Your total is 118.0");
        System.out.println("Order stored (pretend DB).");
        
        System.out.println("\nActual output:");
        orderService.checkout("a@shop.com", 100.0);
    }
}