public class Checking extends Account
{
    private static int x = 1000;
    
    public void withdraw(double x)
    {
        if(super.getBalance() < x)
        {
            this.x -= x-super.getBalance();
            super.setBalance(0);
        }
        else if(super.getBalance() <= 0)
            this.x -= x;
        else
            super.withdraw(x);
    }

    @Override
    public String toString() {
        return "Checking{" + '}';
    }
}
