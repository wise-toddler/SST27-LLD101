public class TestDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing refactored ex05:");
        
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(4);
        System.out.println("Rectangle area (5x4): " + rect.area()); // 20
        
        Square square = new Square();
        square.setSide(4);
        System.out.println("Square area (4x4): " + square.area()); // 16
        
        System.out.println("\nLSP Test - Polymorphic behavior:");
        Shape[] shapes = {rect, square};
        for (Shape shape : shapes) 
        {
            System.out.println("Shape area: " + shape.area());
        }
        
        System.out.println("\nNo more LSP violation - each class has proper behavior!");
    }
}