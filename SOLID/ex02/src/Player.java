public class Player 
{
    private Frame last;
    private Decoder decoder;
    
    public Player(Decoder decoder) 
    {
        this.decoder = decoder;
    }
    
    public void play(byte[] fileBytes)
    {
        // decode
        Frame f = decoder.decode(fileBytes);
        last = f;
        // draw UI
        System.out.println("\u25B6 Playing " + fileBytes.length + " bytes");
        // cache
        System.out.println("Cached last frame? " + (last!=null));
    }
}