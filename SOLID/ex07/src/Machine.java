interface Printable 
{
    void print(String text);
}

interface Scannable 
{
    void scan(String dstPath);
}

interface Faxable 
{
    void fax(String number);
}

interface Machine extends Printable, Scannable, Faxable 
{
    // All-in-one machine interface
}
