public class Saving extends Account
{
    public void withdraw(double x)
    {
        if(super.getBalance()-x <0 || super.getBalance()==0)
            System.out.println("There is no enough blance");
    }

    @Override
    public String toString() {
        return "Saving{" + '}';
    }

}
