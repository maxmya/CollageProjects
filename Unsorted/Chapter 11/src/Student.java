public class Student extends Person
{
    final int freshman = 1;
    final int sophomore = 2;
    final int junior = 3;
    final int senior = 4;
    private int status;

    public Student() 
    {
    }
    
    public Student(int status) 
    {
        this.status = status;
    }

    public int getStatus() 
    {
        return status;
    }

    public void setStatus(int status) 
    {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\nand his status is " + getStatus();
    }
}
