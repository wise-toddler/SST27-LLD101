
public class PaymentService 
{
    public String pay(Payment p)
    {
        try 
        {
            return PaymentProvider.valueOf(p.provider).processPayment(p.amount);
        } 
        catch (IllegalArgumentException e) 
        {
            throw new RuntimeException("No provider");
        }
    }
}