public enum PaymentProvider 
{
    CARD("Charged card: "), 
    UPI("Paid via UPI: "), 
    WALLET("Wallet debit: ");
    
    private final String messagePrefix;
    
    PaymentProvider(String messagePrefix) 
    {
        this.messagePrefix = messagePrefix;
    }
    
    public String processPayment(double amount) 
    {
        return messagePrefix + amount;
    }
}