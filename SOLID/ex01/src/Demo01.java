public class Demo01 
{
    public static void main(String[] args) 
    {  
        EmailClient emailClient = new EmailClient();
        TaxCalculator taxCalculator = new TaxCalculator();
        OrderService orderService = new OrderService(emailClient, taxCalculator);
        orderService.checkout("a@shop.com", 100.0);
    }
}