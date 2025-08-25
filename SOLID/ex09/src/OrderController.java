public class OrderController 
{
    private OrderRepository repo;
    
    public OrderController(OrderRepository repo) 
    {
        this.repo = repo;
    }
    
    public void create(String id) 
    {
        repo.save(id);
        System.out.println("Created order: " + id);
    }
}