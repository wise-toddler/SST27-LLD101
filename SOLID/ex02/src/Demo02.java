public class Demo02 
{
    public static void main(String[] args) 
    {
        Decoder decoder = new Decoder();
        Player player = new Player(decoder);
        player.play(new byte[]{1,2,3,4});
    }
}
