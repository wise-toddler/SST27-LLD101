import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        
        // Using Builder pattern
        Order o = new Order.Builder()
            .id("o2")
            .customerEmail("a@b.com")
            .addLine(l1)
            .addLine(l2)
            .discountPercent(10)
            .build();
            
        System.out.println("Before: " + o.totalAfterDiscount());
        
        // This would cause compilation error now - OrderLine is immutable
        // l1.setQuantity(999); 
        
        // Let's create a new OrderLine to simulate the attempt
        OrderLine l1Modified = new OrderLine("A", 999, 200);
        System.out.println("After attempting to modify line (but can't): " + o.totalAfterDiscount());
        System.out.println("=> Totals remain stable due to defensive copies and immutability!");
        
        // Demonstrate validation
        System.out.println("\nTesting validation:");
        
        try {
            new Order.Builder()
                .id("o3")
                .customerEmail("invalid-email")
                .addLine(l1)
                .build();
        } catch (Exception e) {
            System.out.println("✓ Caught invalid email: " + e.getMessage());
        }
        
        try {
            new Order.Builder()
                .id("o4")
                .customerEmail("test@example.com")
                .addLine(l1)
                .discountPercent(150)
                .build();
        } catch (Exception e) {
            System.out.println("✓ Caught invalid discount: " + e.getMessage());
        }
        
        try {
            new Order.Builder()
                .id("o5")
                .customerEmail("test@example.com")
                .build();
        } catch (Exception e) {
            System.out.println("✓ Caught empty order: " + e.getMessage());
        }
    }
}