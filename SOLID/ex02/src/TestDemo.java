public class TestDemo 
{
    public static void main(String[] args) 
    {
        System.out.println("Testing refactored ex02:");
        
        Decoder decoder = new Decoder();
        Player player = new Player(decoder);
        
        System.out.println("Expected output:");
        System.out.println("▶ Playing 4 bytes");
        System.out.println("Cached last frame? true");
        
        System.out.println("\nActual output:");
        player.play(new byte[]{1,2,3,4});
    }
}