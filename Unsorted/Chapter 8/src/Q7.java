public class Q7 
{

    public static void main(String[]args)
    {
        
        Account account = new Account(1122,20000);
        account.setAnnualInterestRate(0.045);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("The Balance = " + account.getBalance() 
                + "$, The Monthly Interest = " + account.getMonthlyInterestRate()
                + "$, The Account was created in " + account.getDateCreated());
    }
}
