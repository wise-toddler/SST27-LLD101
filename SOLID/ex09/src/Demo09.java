public class Demo09 
{
    public static void main(String[] args) 
    {
        OrderRepository repository = new SqlOrderRepository();
        OrderController controller = new OrderController(repository);
        controller.create("ORD-1");
    }
}
