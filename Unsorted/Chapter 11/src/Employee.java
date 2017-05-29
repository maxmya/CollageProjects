public class Employee extends Person
{
    private String office;
    private double salary;
    private MyDate dateHired;

    public Employee()
    {
    }

    public Employee(String office, double salary) 
    {
        this.office = office;
        this.salary = salary;
        dateHired = new MyDate();
    }
    
    public String getOffice() 
    {
        return office;
    }

    public void setOffice(String office) 
    {
        this.office = office;
    }

    public double getSalary() 
    {
        return salary;
    }

    public void setSalary(double salary) 
    {
        this.salary = salary;
    }

    public MyDate getDateHired()
    {
        return dateHired;
    }
  
    @Override
    public String toString()
    {
        return super.toString() + "\nand his office is" + getOffice()
                + ", his salary = " + getSalary() + ", and his date hired is"
                + getDateHired();
    }
}

class MyDate 
{
    private int year;
    private int month;
    private int day;

    public MyDate() 
    {
    }

    public MyDate(int year, int month, int day) 
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth() 
    {
        return month;
    }

    public int getDay() 
    {
        return day;
    }
}