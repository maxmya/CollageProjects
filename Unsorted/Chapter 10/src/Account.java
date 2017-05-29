import java.util.Date;
public class Account 
{
    
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated =  new Date(System.currentTimeMillis());
    
    public Account()
    {}
    
    public Account(int newId, double initialBalance)
    {
        id = newId;
        balance = initialBalance;
    }
    
    public void setId(int newId)
    {
        id = newId;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setBalance(int newBalance)
    {
        balance = newBalance;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void setAnnualInterestRate(double newAnnualInterestRate)
    {
        annualInterestRate = newAnnualInterestRate;
    }
    
    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }
    
    public Date getDateCreated()
    {
       return dateCreated; 
    }
    
    public double getMonthlyInterestRate()
    {
        return annualInterestRate/12;
    }
    
    public void withdraw(double x)
    {
        balance -= x;
    }
    
    public void deposit(double x)
    {
        balance += x;
    }
}
