public class Aviary 
{
    public void release(Flyable flyable)
    { 
        flyable.fly(); 
        System.out.println("Released"); 
    }
}