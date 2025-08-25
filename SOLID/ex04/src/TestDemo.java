public class TestDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing refactored ex04:");
        
        PaymentService service = new PaymentService();
        
        System.out.println("Expected: Paid via UPI: 499.0");
        System.out.print("Actual: ");
        System.out.println(service.pay(new Payment("UPI", 499)));
        
        System.out.println("\nTesting all providers:");
        System.out.println("CARD: " + service.pay(new Payment("CARD", 100)));
        System.out.println("UPI: " + service.pay(new Payment("UPI", 200))); 
        System.out.println("WALLET: " + service.pay(new Payment("WALLET", 300)));
        
        System.out.println("\nTesting invalid provider:");
        try {
            System.out.println("CRYPTO: " + service.pay(new Payment("CRYPTO", 50)));
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}