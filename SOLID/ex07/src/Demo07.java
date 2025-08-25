public class Demo07 
{
    public static void main(String[] args) 
    {
        Printable printer = new BasicPrinter();
        printer.print("Hello");
        // printer.scan("/tmp/out");
        System.out.println("only print fn");
    }
}
