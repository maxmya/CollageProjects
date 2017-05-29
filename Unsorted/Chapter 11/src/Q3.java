public class Q3 
{
    public static void main(String[]args)
    {
        Saving s = new Saving();
        Checking c = new Checking();
        Account a = new Account();
        s.withdraw(500);
        c.withdraw(100);
        System.out.println(s.toString() + c.toString() + a.toString());
    }
}
