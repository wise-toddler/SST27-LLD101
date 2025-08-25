public class OrderService 
{
    private EmailClient email;
    private TaxCalculator taxCalculator;
    
    public OrderService(EmailClient emailClient, TaxCalculator taxCalculator) 
    {
        this.email = emailClient;
        this.taxCalculator = taxCalculator;
    }
    public void checkout(String customerEmail, double subtotal) 
    {
        double total = taxCalculator.calculateTotal(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}